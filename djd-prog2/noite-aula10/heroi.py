import pygame
from config import *


def get_image(spritesheet, gid):
    img = get_image_bygid(spritesheet, gid, columns=12)
    return pygame.transform.scale(img, (BLOCK_W, BLOCK_H))


class Boy(pygame.sprite.Sprite):
    def __init__(self, spritesheet):
        pygame.sprite.Sprite.__init__(self)
        self.img_lista = [get_image(spritesheet, 27), get_image(spritesheet, 28), get_image(spritesheet, 29)]
        self.image = self.img_lista[0]
        self.rect = pygame.Rect((100, 100), (BLOCK_W, BLOCK_H))
        self.vel_x = 0
        self.vel_y = 0
        self.gravidade = 0.009
        self.intencao_pos = list(self.rect.center)
        self.img_index = 0
        self.img_delay = 50
        self.img_count_delay = 0

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
        self.img_count_delay += 1
        if self.img_count_delay > self.img_delay:
            self.img_index += 1
            if self.img_index >= len(self.img_lista):
                self.img_index = 0
            self.image = self.img_lista[self.img_index]
            self.img_count_delay = 0

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
