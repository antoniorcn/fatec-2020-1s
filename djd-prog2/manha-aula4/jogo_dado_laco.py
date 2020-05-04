from random import randint
print("Jogo do dado")


# c = 1
# while c==1:
#     numeroStr = input("Digite um número entre 1 e 6: ")
#     numero = int(numeroStr)
#     if numero >= 1 and numero <= 6:
#         c = 0


# numero = 0
# while numero < 1 or numero > 6:
#     numeroStr = input("Digite um número entre 1 e 6: ")
#     numero = int(numeroStr)
# else:
#     print("Interrompido normalmente")


while 1 == 1:
    numeroStr = input("Digite um número entre 1 e 6: ")
    numero = int(numeroStr)
    if 1 <= numero <= 6:
        break

# while 1 == 1:
#     numeroStr = input("Digite um número entre 1 e 6: ")
#     numero = int(numeroStr)
#     if numero < 1 or numero > 6:
#         continue
#     break
#
#     # if numero < 1:
#     #     continue
#     # if numero > 6:
#     #     continue


sorteado = randint(1, 6)
print("O número sorteado foi", sorteado)

if numero == sorteado:
    print("Parabens você ganhou...")
else:
    print("Que pena você perdeu...")

