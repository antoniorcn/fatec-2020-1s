# Tartaruga do jogo do Super Mario
# Caracteristicas
    # ter_casco
    # cor
    # ter_espinhos
    # tamanho
    # ter_asas

# Comportamento
    # andar()
    # pular()
    # voar()
    # girar()

from random import choice


class Tartaruga():
    ter_casco = True
    ter_espinhos = False
    tamanho = "Grande"
    ter_asas = False

    def __init__(self):
        self.cor = choice(["Vermelha", "Amarela", "Verde", "Azul"])

    def andar(self):
        pass

    def pular(self):
        pass

    def voar(self):
        pass

    def girar(self):
        pass

t1 = Tartaruga()
t2 = Tartaruga()
t3 = Tartaruga()

# t1.cor = "Amarela"

print(t1.cor)
print(t2.cor)
print(t3.cor)
