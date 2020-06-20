import pygame

WIDTH = 800
HEIGHT = 600

pygame.init()

matriz = [
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    "...PPPPP.........................................................................",
    ".................................................................................",
    ".......PPPPP.....................................................................",
    ".................................................................................",
    ".................................................................................",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
]

screen = pygame.display.set_mode((WIDTH, HEIGHT), 0)
BLOCK_W = WIDTH // 16
BLOCK_H = HEIGHT // 12

caracteres = pygame.image.load("./characters.png")
boy_orig = caracteres.subsurface((16 * 4, 16 * 2), (16, 16))
boy = pygame.transform.scale(boy_orig, (BLOCK_W, BLOCK_H))

while True:
    # pintar o cenario
    for linha, lin in enumerate(matriz):
        for coluna in range(0, 16):
            x = coluna * BLOCK_W
            y = linha * BLOCK_H
            bloco = matriz[linha][coluna]
            cor = (0, 0, 0)
            if bloco == "P":
                cor = (255, 255, 0)
            pygame.draw.rect(screen, cor, ((x, y), (BLOCK_W, BLOCK_H)), 0)

    screen.blit(boy, (100, 100))
    pygame.display.update()

    for e in pygame.event.get():
        if e.type == pygame.QUIT:
            exit()