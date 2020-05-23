import pygame

RED = (255, 0, 0)
WHITE = (255, 255, 255)
pygame.init()
tela = pygame.display.set_mode((800, 600), 0)

mario = pygame.image.load("./imagens/mario.png")

tela.fill(WHITE)
pygame.draw.ellipse(tela, RED, ((150, 75), (500, 450)), 0)
tela.blit(mario, (500, 280))

pygame.display.update()

while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
