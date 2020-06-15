import math


def calcular_volume_cilindro(altura, raio = 2):
    area = raio ** 2 * math.pi
    volume = area * altura
    return volume


res = calcular_volume_cilindro(altura=5, raio=2)
print(res)