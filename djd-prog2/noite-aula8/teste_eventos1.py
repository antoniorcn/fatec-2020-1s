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
vel_y = VELOCIDADE
vel_x = VELOCIDADE
cores = [AMARELO, VERMELHO, AZUL, VERDE]
cor = AMARELO
while True:
    # Calcular as regras do jogo
    x = x + vel_x
    y = y + vel_y

    if y + raio > 600:
        vel_y = -VELOCIDADE
        cor = choice(cores)
    if y - raio < 0:
        vel_y = VELOCIDADE
        cor = choice(cores)
    if x + raio > 800:
        vel_x = -VELOCIDADE
        cor = choice(cores)
    if x - raio < 0:
        vel_x = VELOCIDADE
        cor = choice(cores)

    # Pintar a tela
    tela.fill(PRETO)
    pygame.draw.circle(tela, cor, (int(x), int(y)), raio, 0)
    pygame.display.update()

    # Captura eventos
    for evt in pygame.event.get():
        if evt.type == pygame.QUIT:
            exit()