# -*-coding:utf8-*-
from random import randint
print("Jogo do dado")
numeroStr = input("Digite um número entre 1 e 6: ")   # 5
# numeroStr = "5"
numero = int(numeroStr)
# numero = 5
# num = int(input("Digite um numero entre 1 e 6:"))
sorteado = randint(1, 6)
print("O número sorteado foi", sorteado)
acertou = numero == sorteado
print("Voce acertou: ", acertou)

if numero == sorteado:
    print("Parabens você ganhou...")
    if numero == 6:
        print("Cara parabens ... você tem muita sorte")
    else:
        print("Você é mais conservador")
else:
    print("Que pena você perdeu...")
    if numero == 1:
        print("Puxa você não arrisca quase nada e mesmo assim perde")

# if numero != sorteado:
#    print("Que pena você perdeu...")
