import pygame

pygame.init()


tela = pygame.display.set_mode((800, 600), pygame.VIDEORESIZE)

while True:
    lista_eventos = pygame.event.get()
    for e in lista_eventos:
        if e.type == pygame.QUIT:
            exit()
        elif e.type == pygame.MOUSEBUTTONDOWN:
            print(f'Type: BOTAO MOUSE  Pos: {e.pos}  Button: {e.button}')
        elif e.type == pygame.KEYDOWN:
            print(f'Type: TECLADO  Key: {e.key}  Mod: {e.mod}')
