import pygame
from random import randint
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)

while True:
    # Pinta a tela
    red = randint(0, 255)
    green = randint(0, 255)
    blue = randint(0, 255)
    x = randint(0, 800)
    y = randint(0, 600)
    w = randint(0, 400)
    h = randint(0, 300)
    cor = (red, green, blue)
    r = pygame.Rect((x, y), (w, h))
    pygame.draw.rect(tela, cor, r, 0)

    pygame.display.update()

    # Captura Eventos
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
