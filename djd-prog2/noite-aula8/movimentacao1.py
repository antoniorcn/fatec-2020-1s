import pygame
from random import choice
AMARELO = (255, 255, 0)
VERMELHO = (255, 0, 0)
AZUL = (0, 0, 255)
VERDE = (0, 255, 0)
PRETO = (0, 0, 0)
VELOCIDADE = 0.5
tela = pygame.display.set_mode((800, 600))
x = 100
y = 100
raio = 30
vel_y = 0
vel_x = 0
cores = [AMARELO, VERMELHO, AZUL, VERDE]
cor = AMARELO
while True:
    # Calcular as regras do jogo
    x = x + vel_x
    y = y + vel_y

    # Pintar a tela
    tela.fill(PRETO)
    pygame.draw.circle(tela, cor, (int(x), int(y)), raio, 0)
    pygame.display.update()

    # Captura eventos
    for evt in pygame.event.get():
        if evt.type == pygame.QUIT:
            exit()
        if evt.type == pygame.KEYDOWN:
            if evt.key == pygame.K_d:
                vel_x = VELOCIDADE
            if evt.key == pygame.K_a:
                vel_x = -VELOCIDADE
            if evt.key == pygame.K_w:
                vel_y = -VELOCIDADE
            if evt.key == pygame.K_s:
                vel_y = VELOCIDADE
        if evt.type == pygame.KEYUP:
            # if evt.key in [pygame.K_d, pygame.K_a]:
            #    vel_x = 0
            # if evt.key == pygame.K_d:
            #     vel_x = 0
            # if evt.key == pygame.K_a:
            #   vel_x = 0
            if evt.key in [pygame.K_a, pygame.K_d]:
                vel_x = 0
            if evt.key in [pygame.K_w, pygame.K_s]:
                vel_y = 0
