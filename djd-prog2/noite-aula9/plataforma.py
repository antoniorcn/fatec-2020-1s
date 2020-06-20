import pygame

WIDTH = 800
HEIGHT = 600

pygame.init()

matriz = [
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    "...PPPPP.........................................................................",
    ".................................................................................",
    ".......PPPPP.....................................................................",
    ".................................................................................",
    ".................................................................................",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
]

screen = pygame.display.set_mode((WIDTH, HEIGHT), 0)
BLOCK_W = WIDTH // 16
BLOCK_H = HEIGHT // 12

caracteres = pygame.image.load("./characters.png")


class Boy(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        boy_orig = caracteres.subsurface((16 * 4, 16 * 2), (16, 16))
        self.image = pygame.transform.scale(boy_orig, (BLOCK_W, BLOCK_H))
        self.rect = pygame.Rect((100, 100), (BLOCK_W, BLOCK_H))
        self.vel_x = 0
        self.vel_y = 0
        self.gravidade = 0.009

    def mover_esquerda(self):
        self.vel_x = -1

    def mover_direita(self):
        self.vel_x = 1

    def pular(self):
        self.vel_y = -1

    def update(self, *args):
        self.vel_y += self.gravidade
        self.rect.centerx += self.vel_x
        self.rect.centery += self.vel_y

    def parar_horizontal(self):
        self.vel_x = 0


boy = Boy()
herois = pygame.sprite.Group(boy)

while True:
    # pintar o cenario
    for linha, lin in enumerate(matriz):
        for coluna in range(0, 16):
            x = coluna * BLOCK_W
            y = linha * BLOCK_H
            bloco = matriz[linha][coluna]
            cor = (0, 0, 0)
            if bloco == "P":
                cor = (255, 255, 0)
            pygame.draw.rect(screen, cor, ((x, y), (BLOCK_W, BLOCK_H)), 0)

    herois.draw(screen)

    pygame.display.update()


    # calcular regras
    herois.update()

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
        if e.type == pygame.KEYUP:
#            if e.key == pygame.K_LEFT or e.key == pygame.K_RIGHT:
            if e.key in [pygame.K_LEFT, pygame.K_RIGHT]:
                boy.parar_horizontal()
