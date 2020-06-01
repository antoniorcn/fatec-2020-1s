from random import randint, choice

cartas = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
jog1 = []
jog2 = []
print("Baralho:", cartas)
print("Mao jogador 1:", jog1)
print("Mao jogador 2:", jog2)
pos = randint(0, len(cartas) - 1)
carta = cartas.pop(pos)
jog1.append(carta)

print("Baralho:", cartas)
print("Mao jogador 1:", jog1)
print("Mao jogador 2:", jog2)

carta = jog1.pop(0)
cartas.append(carta)

print("Baralho:", cartas)
print("Mao jogador 1:", jog1)
print("Mao jogador 2:", jog2)

cartas.clear()
print("Baralho:", cartas)
