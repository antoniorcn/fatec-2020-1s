import pygame

RED = (255, 0, 0)
WHITE = (255, 255, 255)
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)
# tela.fill(WHITE)
vertices = [(200, 300), (400, 50), (600, 300)]
pygame.draw.polygon(tela, RED, vertices, 3)

# r = ((200, 300), (400, 250))
r = pygame.Rect((200, 300), (400, 250))
# pygame.draw.rect(tela, RED, ((200, 300), (400, 250)), 3)

pygame.draw.rect(tela, RED, r, 3)


pygame.display.update()

while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
