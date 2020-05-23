import pygame
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))

lista = [(300, 0), (600, 400), (0, 400)]

pygame.draw.polygon(screen, AMARELO, lista, 0)

pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
