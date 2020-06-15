#  3x² - 5x + 4 = 16

# delta = B² - 4 * A * C
# x1 = -B + SQRT(delta) / 2 * A
# x2 = -B - SQRT(delta) / 2 * A

import math


def equacao2grau(a, b, c):
    """" Função para calculo de equação do 2º grau
        Informe os valores para A, B e C sendo o valor de X²
    """
    delta = b * b - 4 * a * c
    print("Delta: {}".format(delta))
    x1 = (-b + math.sqrt(delta)) / (2 * a)
    x2 = (-b - math.sqrt(delta)) / (2 * a)
    print("x1: {}    x2: {}".format(x1, x2))
    return x1, x2


xa, xb = equacao2grau(3, -5, -4)

print("Resultado: ", xa, "  e ", xb)

equ

