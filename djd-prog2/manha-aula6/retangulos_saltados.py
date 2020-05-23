import pygame
from random import randint
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))
tipo = 0           # 0 - Retangulo  1 - Ellipse
while True:
    x = randint(0, 600)
    y = randint(0, 400)
    w = randint(0, 200)
    h = randint(0, 200)
    red = randint(0, 255)
    green = randint(0, 255)
    blue = randint(0, 255)
    tipo = randint(0, 1)
    if tipo == 0:
        pygame.draw.rect(screen, (red, green, blue), ((x, y), (w, h)), 0)
    elif tipo == 1:
        pygame.draw.ellipse(screen, (red, green, blue), ((x, y), (w, h)), 0)
    pygame.display.update()
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
