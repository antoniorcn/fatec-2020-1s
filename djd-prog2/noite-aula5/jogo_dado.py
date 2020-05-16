from random import randint
cpu = randint(1, 6)                     # 2
num = 7
while num < 1 or num > 6:
    strnum = input("Digite um número entre 1 e 6: ")    # "2"
    num = int(strnum)                       # 2
print("O numero no dado foi: ", cpu)
resultado = cpu == num
print("Você ganhou: ", resultado)
if cpu == num:
    print("Eba você acertou !!!")
else:
    print("Que pena vc errou !!!")
print("Fim do programa")
