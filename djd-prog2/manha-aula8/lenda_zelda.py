import pygame

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
AMARELO = (0xFF, 0xFF, 0x00)
PRETO = (0x00, 0x00, 0x00)
TELA_WIDTH = 800
TELA_HEIGHT = 600

BLK_WIDTH = TELA_WIDTH // 40
BLK_HEIGHT = TELA_HEIGHT // 20

pygame.init()
tela = pygame.display.set_mode((TELA_WIDTH, TELA_HEIGHT))

def load_image(img_set, x, y):
        img_orig = img_set.subsurface((x, y), (16, 16))
        img_scaled = pygame.transform.scale(img_orig, (BLK_WIDTH, BLK_HEIGHT))
        return img_scaled

tiles = pygame.image.load("./basictiles.png").convert_alpha()
characters = pygame.image.load("./characters.png").convert_alpha()

img_vaso = load_image(tiles, 48, 48)
img_grama = load_image(tiles, 16, 128)
img_parede = load_image(tiles, 48, 0)

class Personagem(pygame.sprite.Sprite):
        def __init__(self):
                pygame.sprite.Sprite.__init__(self)
                car_img_1 = load_image(characters, 48, 0)
                car_img_2 = load_image(characters, 64, 0)
                car_img_3 = load_image(characters, 80, 0)
                self.lista_imagens = [car_img_1, car_img_2, car_img_3]
                self.image_idx = 0
                self.image = car_img_1
                self.rect = pygame.Rect((32, 32), (BLK_WIDTH, BLK_HEIGHT))

        def update(self):
                self.image = self.lista_imagens[self.image_idx]
                self.image_idx += 1
                if self.image_idx >= len(self.lista_imagens):
                        self.image_idx = 0



heroi = Personagem()
grupo_heroi = pygame.sprite.Group(heroi)

while True:
        for id_linha, linha in enumerate(mapa):
                for id_coluna, caracter in enumerate(linha):
                        # cor = PRETO
                        # if caracter == 'p':
                        #        cor = AMARELO
                        x = id_coluna * BLK_WIDTH
                        y = id_linha * BLK_HEIGHT
                        if caracter == 'p':
                                tela.blit(img_parede, (x, y))
                        else:
                                tela.blit(img_grama, (x, y))
                        # r = pygame.Rect((x, y), (BLK_WIDTH, BLK_HEIGHT))
                        # pygame.draw.rect(tela, cor, r, 0)

        for id_linha, linha in enumerate(mapa_objs):
                for id_coluna, caracter in enumerate(linha):
                        x = id_coluna * BLK_WIDTH
                        y = id_linha * BLK_HEIGHT
                        if caracter == 'v':
                                tela.blit(img_vaso, (x, y))

        grupo_heroi.draw(tela)
        pygame.display.update()

        grupo_heroi.update()

        for e in pygame.event.get():
                if e.type == pygame.QUIT:
                        exit()

