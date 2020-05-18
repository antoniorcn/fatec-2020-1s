import pygame
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))

pygame.draw.ellipse(screen, AMARELO, ((10, 10), (580, 380)), 3)

pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
