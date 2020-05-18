import pygame
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))

img = pygame.image.load("./circulo.png")

screen.blit(img, (100, 100))

pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
