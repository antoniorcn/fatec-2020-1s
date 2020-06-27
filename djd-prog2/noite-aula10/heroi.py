import pygame
from config import *


class Boy(pygame.sprite.Sprite):
    def __init__(self, spritesheet):
        pygame.sprite.Sprite.__init__(self)
        boy_orig = get_image_bygid(spritesheet, 31, columns=12)
        self.image = pygame.transform.scale(boy_orig, (BLOCK_W, BLOCK_H))
        self.rect = pygame.Rect((100, 100), (BLOCK_W, BLOCK_H))
        self.vel_x = 0
        self.vel_y = 0
        self.gravidade = 0.009
        self.intencao_pos = list(self.rect.center)

    def mover_esquerda(self):
        self.vel_x = -1

    def mover_direita(self):
        self.vel_x = 1

    def pular(self):
        self.vel_y = -1
        self.intencao_pos[1] += self.vel_y

    def update(self, *args):
        self.vel_y += self.gravidade
        self.intencao_pos[0] += self.vel_x
        self.intencao_pos[1] += self.vel_y

    def parar_horizontal(self):
        self.vel_x = 0

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
