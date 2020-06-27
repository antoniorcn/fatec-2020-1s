import pygame

WIDTH = 800
HEIGHT = 600

matriz = [
    ".................................................................................",
    ".................................................................................",
    ".................................................................................",
    ".................................................................PPPPPPP.........",
    "....................................................PPPPPPPPP....................",
    ".................................................................................",
    "...PPPPP.............................PPPPPPPP....................................",
    ".....................PPPPPP......................................................",
    ".......PPPPP.....................................................................",
    ".................................................................................",
    ".............................M...................................................",
    "PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
]

BLOCK_W = WIDTH // 16
BLOCK_H = HEIGHT // 12


def get_image_bygid(spritesheet, gid, columns=12, w=16, h=16, space_h=0, space_v=0, top=0, left=0):
    linha = gid // columns
    coluna = gid % columns
    x = (coluna * (w + space_h)) + left
    y = (linha * (h + space_v)) + top
    return spritesheet.subsurface((x, y), (w, h))


def get_image(spritesheet, gid, columns=12):
    img = get_image_bygid(spritesheet, gid, columns=columns)
    return pygame.transform.scale(img, (BLOCK_W, BLOCK_H))


class ListaCircularImage:
    def __init__(self, spritesheet, columns=12, gids=[], delay=10):
        self.img_lista = []
        for gid in gids:
            img = get_image(spritesheet, gid, columns)
            self.img_lista.append(img)
        self.index = 0
        self.delay = delay
        self.count_delay = 0

    def next(self):
        self.count_delay += 1
        if self.count_delay >= self.delay:
            self.index += 1
            if self.index >= len(self.img_lista):
                self.index = 0
            self.count_delay = 0
        return self.img_lista[self.index]



