import pygame

RED = (255, 0, 0)
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
pygame.draw.line(tela, RED, (400, 50), (200, 300), 3)
pygame.draw.line(tela, RED, (400, 50), (600, 300), 3)
pygame.draw.line(tela, RED, (200, 300), (600, 300), 3)
pygame.draw.line(tela, RED, (200, 300), (200, 550), 3)
pygame.draw.line(tela, RED, (600, 300), (600, 550), 3)
pygame.draw.line(tela, RED, (200, 550), (600, 550), 3)
pygame.display.update()

while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
