import pygame

tela = pygame.display.set_mode((800, 600))


imagens = {}
imagens['boy'] = pygame.image.load("./images/boy.png")
imagens['rio'] = pygame.image.load("./images/rio.png")
imagens['casa'] = pygame.image.load("./images/casa.png")

while True:

    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.MOUSEBUTTONDOWN:
            if e.button == pygame.BUTTON_LEFT:
                tela.blit(imagens['boy'], e.pos)
            elif e.button == pygame.BUTTON_MIDDLE:
                tela.blit(imagens['rio'], e.pos)
            elif e.button == pygame.BUTTON_RIGHT:
                tela.blit(imagens['casa'], e.pos)

        if e.type == pygame.QUIT:
            exit()