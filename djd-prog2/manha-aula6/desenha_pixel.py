import pygame

pygame.init()

screen = pygame.display.set_mode((600, 400))

screen.set_at((300, 200), (255, 255, 0))
screen.set_at((301, 200), (255, 255, 0))
screen.set_at((299, 200), (255, 255, 0))
screen.set_at((300, 199), (255, 255, 0))
screen.set_at((300, 201), (255, 255, 0))
screen.set_at((302, 200), (255, 255, 0))
screen.set_at((298, 200), (255, 255, 0))
screen.set_at((300, 198), (255, 255, 0))
screen.set_at((300, 202), (255, 255, 0))


pygame.display.update()

while True:
    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()