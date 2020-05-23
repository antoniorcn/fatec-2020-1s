import pygame
pygame.init()
CIANO = (0, 255, 255)
AMARELO = (255, 255, 0)
tela = pygame.display.set_mode( (800, 600), 0, 32 )
tela.set_at( (10, 10), CIANO )
# Desenha linha
pygame.draw.line(tela, AMARELO, (11, 11), (790, 590), 1)
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            quit()

