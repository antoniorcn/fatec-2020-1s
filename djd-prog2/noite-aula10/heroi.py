import pygame
from config import *


class Boy(pygame.sprite.Sprite):
    def __init__(self, spritesheet):
        pygame.sprite.Sprite.__init__(self)
        self.img_lista_left = ListaCircularImage(spritesheet, 12, [18, 19, 20], 20)
        self.img_lista_right = ListaCircularImage(spritesheet, 12, [30, 31, 32], 20)
        self.img_lista_stop = ListaCircularImage(spritesheet, 12, [31], 20)
        self.estado = "STOP"   # LEFT - Indo para a esquerda    e RIGHT indo para a direita
        self.img_lista = self.img_lista_stop
        self.image = self.img_lista.next()
        self.rect = pygame.Rect((100, 100), (BLOCK_W, BLOCK_H))
        self.vel_x = 0
        self.vel_y = 0
        self.gravidade = 0.009
        self.intencao_pos = list(self.rect.center)

    def mover_esquerda(self):
        self.vel_x = -1
        self.estado = "LEFT"

    def mover_direita(self):
        self.vel_x = 1
        self.estado = "RIGHT"

    def pular(self):
        self.vel_y = -1
        self.intencao_pos[1] += self.vel_y

    def update(self, *args):
        self.vel_y += self.gravidade
        self.intencao_pos[0] += self.vel_x
        self.intencao_pos[1] += self.vel_y

        if self.estado == "STOP":
            self.img_lista = self.img_lista_stop
        elif self.estado == "LEFT":
            self.img_lista = self.img_lista_left
        elif self.estado == "RIGHT":
            self.img_lista = self.img_lista_right

        self.image = self.img_lista.next()

    def parar_horizontal(self):
        self.vel_x = 0
        self.estado = "STOP"

    def autorizar_movimento(self):
        self.rect.center = self.intencao_pos

    def recusar_movimento(self):
        self.intencao_pos = list(self.rect.center)

    # def testa_colisao_mask(self, spr1, spr2):
    #     return pygame.sprite.collide_mask(spr1, spr2)

    def teste_colisao(self, grupo):
        temp = self.rect.center
        self.rect.center = self.intencao_pos
        # if not pygame.sprite.spritecollide(self, grupo, False, self.testa_colisao_mask):
        if not pygame.sprite.spritecollide(self, grupo, False):
            self.autorizar_movimento()
        else:
            self.rect.center = temp
            self.vel_y = 0
            self.recusar_movimento()
