import pygame
from random import randint

AMARELO = (0xFF, 0xFF, 0x00)
PRETO = (0x00, 0x00, 0x00)
TELA_WIDTH = 800
TELA_HEIGHT = 600
VELOCIDADE = 5.0
BLK_WIDTH = TELA_WIDTH // 40 * 2
BLK_HEIGHT = TELA_HEIGHT // 20 * 2


def load_image(img_set, x, y):
    img_orig = img_set.subsurface((x, y), (16, 16))
    img_scaled = pygame.transform.scale(img_orig, (BLK_WIDTH, BLK_HEIGHT))
    return img_scaled

# p - parede
# <space> - area em branco
mapa = [
        "pppppppppppppppppppppppppppppppppppppppp",
        "p                                      p",
        "p                                      p",
        "p                                      p",
        "p                                      p",
        "p                                      p",
        "p                                      p",
        "p                         ppppppp      p",
        "p                         p            p",
        "p                         p            p",
        "p                 ppppppppp            p",
        "p                 p                    p",
        "p                 p                    p",
        "p                 p                    p",
        "p                 p                    p",
        "p                 p                    p",
        "p         ppppppppp                    p",
        "p                                      p",
        "p                                      p",
        "pppppppppppppppppppppppppppppppppppppppp",
]

mapa_objs = [
        "                                        ",
        "            v                 v         ",
        "                                        ",
        "                                        ",
        "                                        ",
        "         v                              ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                            v           ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        ",
        "                                        "
]

pygame.init()
tela = pygame.display.set_mode((TELA_WIDTH, TELA_HEIGHT))

tiles = pygame.image.load("./basictiles.png").convert_alpha()
characters = pygame.image.load("./characters.png").convert_alpha()

img_vaso = load_image(tiles, 48, 48)
img_grama = load_image(tiles, 16, 128)
img_parede = load_image(tiles, 48, 0)


def teste_colisao_mapa(personagem, map, lista_caracteres):
        colisoes = []
        for id_linha, linha in enumerate(map):
                for id_coluna, caracter in enumerate(linha):
                        if caracter in lista_caracteres:
                                x = id_coluna * BLK_WIDTH
                                y = id_linha * BLK_HEIGHT
                                r = pygame.Rect((x, y), (BLK_WIDTH, BLK_HEIGHT))
                                r2 = personagem.rect.copy()
                                r2.move_ip(personagem.vel_x, personagem.vel_y)
                                if r.colliderect(r2):
                                        colisao = {"linha": id_linha, "coluna": id_coluna, "caracter": caracter}
                                        colisoes.append(colisao)
        return colisoes


class Camera:
        def __init__(self, position, tamanho):
                self.window = pygame.Rect(position, tamanho)
                self.position = position
                self.offset_x = 0
                self.offset_y = 0
                self.clean_image = pygame.Surface(self.window.size)
                self.clean_image.fill(PRETO)
                self.draw_area = pygame.Surface(self.window.size)

        def in_viewport(self, r):
                return self.window.colliderect(r)

        def move(self, pos):
                self.window.center = pos
                self.offset_x = self.window.x
                self.offset_y = self.window.y

        def start_drawing(self):
                self.draw_area.blit(self.clean_image, (0, 0))

        def draw_group(self, group):
                for s in group:
                        if self.in_viewport(s.rect):
                                self.draw_area.blit(s.image, (s.rect.x - self.offset_x, s.rect.y - self.offset_y))

        def draw_tiles(self, map, caracter_imagem):
                # Calcula quais colunas dos tiles serão processadas
                tilewidth = BLK_WIDTH
                tileheight = BLK_HEIGHT
                width = len(map[0])
                height = len(map)
                cols = self.window.width // tilewidth
                rows = self.window.height // tileheight
                start_col = self.window.x // tilewidth
                end_col = start_col + cols + 2
                start_row = self.window.y // tileheight
                end_row = start_row + rows + 2
                start_col = max(start_col, 0)
                start_row = max(start_row, 0)
                end_col = min(end_col, width)
                end_row = min(end_row, height)
                # print("start ({}, {})   end({}, {})".format(start_col, start_row, end_col, end_row))
                for linha in range(start_row, end_row):
                        for coluna in range(start_col, end_col):
                                caracter = map[linha][coluna]
                                if caracter in caracter_imagem:
                                        x = coluna * tilewidth
                                        y = linha * tileheight
                                        img = caracter_imagem[caracter]
                                        r = pygame.Rect((x, y), (tilewidth, tileheight))
                                        if self.in_viewport(r):
                                                self.draw_area.blit(img, (r.x - self.offset_x, r.y - self.offset_y))

        def paint(self, tela):
                tela.blit(self.draw_area, self.position)
                pygame.draw.rect(tela, (255, 0, 0), (self.position, self.window.size), 3)


class Personagem(pygame.sprite.Sprite):
        def __init__(self):
                pygame.sprite.Sprite.__init__(self)
                self.hp = 100
                self.vel_x = 0.0
                self.vel_y = 0.0
                car_img_1 = load_image(characters, 48, 0)
                car_img_2 = load_image(characters, 64, 0)
                car_img_3 = load_image(characters, 80, 0)
                self.lista_imagens = [car_img_1, car_img_2, car_img_3]
                self.image_idx = 0
                self.image = car_img_1
                self.rect = pygame.Rect((BLK_WIDTH * 3, BLK_HEIGHT * 3), (BLK_WIDTH, BLK_HEIGHT))

        def update(self):
                self.image = self.lista_imagens[self.image_idx]
                self.image_idx += 1
                if self.image_idx >= len(self.lista_imagens):
                        self.image_idx = 0

                colisoes_movimento = teste_colisao_mapa(self, mapa, ["p"])
                if len(colisoes_movimento) == 0:
                        self.rect.move_ip(self.vel_x, self.vel_y)

                colisoes = teste_colisao_mapa(self, mapa_objs, ["v"])
                for colisao in colisoes:
                        print("Linha: {}   Coluna: {},  Caracter: {}"
                              .format(colisao["linha"], colisao["coluna"], colisao["caracter"]))

                        # Sorteia um Dano ao personagem
                        dano = randint(-50, 150)
                        self.hp = self.hp - dano
                        if self.hp <= 0:
                                self.kill()
                        print("HP: ", self.hp)

                        # Remove o vaso do mapa
                        linha = mapa_objs[colisao["linha"]]
                        lista = list(linha)
                        lista[colisao["coluna"]] = " "
                        linha_texto = "".join(lista)
                        mapa_objs[colisao["linha"]] = linha_texto

        def processar_evento(self, e):
                if e.type == pygame.KEYDOWN:
                        if e.key == pygame.K_d:
                                self.vel_x = VELOCIDADE
                        if e.key == pygame.K_a:
                                self.vel_x = -VELOCIDADE
                        if e.key == pygame.K_w:
                                self.vel_y = -VELOCIDADE
                        if e.key == pygame.K_s:
                                self.vel_y = VELOCIDADE
                if e.type == pygame.KEYUP:
                        if e.key in [pygame.K_a, pygame.K_d]:
                                self.vel_x = 0.0
                        if e.key in [pygame.K_w, pygame.K_s]:
                                self.vel_y = 0.0


heroi = Personagem()
grupo_heroi = pygame.sprite.Group(heroi)
cam = Camera((0, 0), tela.get_size())
while True:
        cam.start_drawing()
        cam.draw_tiles(mapa, {"p": img_parede, " ": img_grama})
        cam.draw_tiles(mapa_objs, {"v": img_vaso})

        cam.draw_group(grupo_heroi)
        cam.paint(tela)
        pygame.display.update()

        grupo_heroi.update()
        cam.move(heroi.rect.center)

        for e in pygame.event.get():
                if e.type == pygame.QUIT:
                        exit()
                heroi.processar_evento(e)

