class Jogador:
    personagem = "Sonic"
    invencivel = True
    qtd_aneis = 0
    tamanho = "Medio"
    espinhos = True
    cor = "Azul"
    estamina = 100

    def escalar_parede(self):
        pass

    def voar(self):
        pass

    def pegar_anel(self, aneis=1):
        self.qtd_aneis += aneis

    def correr(self):
        self.estamina -= 10

    def pular(self):
        pass

    def girar(self):
        pass

    def __str__(self):
        return "Personagem: {}  Aneis: {}   Estamina: {}"\
            .format(self.personagem, self.qtd_aneis, self.estamina)


j1 = Jogador()
j2 = Jogador()

j2.personagem = "Tails"
j2.pegar_anel()
j2.correr()

j1.correr()
j1.correr()

print(j1)
print(j2)