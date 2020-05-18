import pygame
pygame.init()
tela = pygame.display.set_mode((600, 400), 0)
s1 = pygame.Surface((200, 100), 0)
s1.fill( (255, 0, 0) )
# Vermelho = 255, Verde = 0 , Azul = 0
tela.blit(s1, (300, 200) )
pygame.display.update()
while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()
