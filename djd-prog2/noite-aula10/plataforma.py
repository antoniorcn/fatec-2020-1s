import pygame
from config import *
from heroi import *

pygame.init()

screen = pygame.display.set_mode((WIDTH, HEIGHT), 0)
caracteres = pygame.image.load("./images/characters.png")
basictiles = pygame.image.load("./images/basictiles.png")


class Bloco(pygame.sprite.Sprite):
    def __init__(self, linha, coluna):
        pygame.sprite.Sprite.__init__(self)
        img_orig = get_image_bygid(basictiles, 38, columns=8)
        self.image = pygame.transform.scale(img_orig, (BLOCK_W, BLOCK_H))
        x = coluna * BLOCK_W
        y = linha * BLOCK_H
        self.rect = pygame.Rect((x, y), (BLOCK_W, BLOCK_H))


class Fantasma(pygame.sprite.Sprite):
    def __init__(self, linha, coluna):
        pygame.sprite.Sprite.__init__(self)
        self.img_lista = ListaCircularImage(caracteres, 12, [54, 55, 56], 20)
        self.image = self.img_lista.next()
        self.rect = pygame.Rect((coluna * BLOCK_W, linha * BLOCK_H), (BLOCK_W, BLOCK_H))
        self.vel_x = 0
        self.vel_y = 0

    def update(self, *args):
        self.rect.centerx += self.vel_x
        self.image = self.img_lista.next()


class Tiro(pygame.sprite.Sprite):
    def __init__(self, personagem):
        pygame.sprite.Sprite.__init__(self)
        self.img_lista = ListaCircularImage(basictiles, 8, [60, 61], 20)
        self.image = self.img_lista.next()
        self.rect = pygame.Rect(personagem.rect.center, (BLOCK_W // 2, BLOCK_H // 2))
        self.vel_x = 0
        self.vel_y = 0

    def update(self, *args):
        self.rect.centerx += self.vel_x
        self.image = self.img_lista.next()


class Camera:
    def __init__(self, position, tamanho):
        self.window = pygame.Rect(position, tamanho)
        self.position = position
        self.offset_x = 0
        self.offset_y = 0
        self.clean_image = pygame.Surface(self.window.size)
        self.clean_image.fill((0, 0, 0))
        self.draw_area = pygame.Surface(self.window.size)

    def in_viewport(self, r):
        return self.window.colliderect(r)

    def move(self, pos):
        self.window.center = pos
        self.offset_x = self.window.x
        self.offset_y = self.window.y

    def start_drawing(self):
        self.draw_area.blit(self.clean_image, (0, 0))

    def paint(self, tela):
        tela.blit(self.draw_area, self.position)
        pygame.draw.rect(tela, (255, 0, 0), (self.position, self.window.size), 3)

    def draw_group(self, group):
        for s in group:
            if self.in_viewport(s.rect):
                self.draw_area.blit(s.image, (s.rect.x - self.offset_x, s.rect.y - self.offset_y))


boy = Boy(caracteres)
herois = pygame.sprite.Group(boy)
blocos = pygame.sprite.Group()
inimigos = pygame.sprite.Group()
tiros = pygame.sprite.Group()

for linha, lin in enumerate(matriz):
    for coluna in range(0, 80):
        elemento = matriz[linha][coluna]
        if elemento == "P":
            bloco = Bloco(linha, coluna)
            blocos.add(bloco)
        elif elemento == "M":
            inimigo = Fantasma(linha, coluna)
            inimigos.add(inimigo)

cam = Camera((0, 0), (WIDTH, HEIGHT))

while True:
    # pintar cenario
    cam.start_drawing()
    cam.draw_group(blocos)
    cam.draw_group(herois)
    cam.draw_group(inimigos)
    cam.draw_group(tiros)
    #screen.fill((0, 0, 0))
    #blocos.draw(screen)
    #herois.draw(screen)
    cam.paint(screen)
    pygame.display.update()


    # calcular regras
    herois.update()
    tiros.update()
    inimigos.update()
    boy.teste_colisao(blocos)

    pygame.sprite.groupcollide(inimigos, tiros, True, True)

    for tiro in tiros:
        if tiro.rect.centerx > boy.rect.centerx + 200:
            tiro.kill()
        if tiro.rect.centerx < boy.rect.centerx - 200:
            tiro.kill()

    cam.move(boy.rect.center)

    # processa eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
        if e.type == pygame.KEYDOWN:
            if e.key == pygame.K_RIGHT:
                boy.mover_direita()
            if e.key == pygame.K_LEFT:
                boy.mover_esquerda()
            if e.key == pygame.K_SPACE:
                boy.pular()
            if e.key == pygame.K_x:
                tiro = Tiro(boy)
                tiros.add(tiro)
                if boy.estado == "LEFT":
                    tiro.vel_x = -1
                elif boy.estado in ["RIGHT", "STOP"]:
                    tiro.vel_x = 1
        if e.type == pygame.KEYUP:
#            if e.key == pygame.K_LEFT or e.key == pygame.K_RIGHT:
            if e.key in [pygame.K_LEFT, pygame.K_RIGHT]:
                boy.parar_horizontal()
