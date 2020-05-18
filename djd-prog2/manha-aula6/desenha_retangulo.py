import pygame
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))
r = pygame.Rect((10, 10), (580, 380))
# pygame.draw.rect(screen, AMARELO, ((10, 10), (580, 380)), 1)
pygame.draw.rect(screen, AMARELO, r, 1)

pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
