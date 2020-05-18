import pygame
pygame.init()
AMARELO = (255, 255, 0)
screen = pygame.display.set_mode((600, 400))
pygame.draw.line(screen, AMARELO, (0, 0), (600, 400), 5)
pygame.display.update()
# Crie uma tela e desenhe 4 linha no perímetro tela
# com um espaçamento de 10 pixels da borda e
# cada linha contendo 3 pixel de espessura
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
