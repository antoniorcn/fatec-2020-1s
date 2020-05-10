soma = int(input("Digite a soma das cartas"))
if soma <= 10:
    print("Sem duvida compre outra carta")
elif soma <= 15:
    print("Há um risco, mas aconselho a comprar outra carta")
elif soma <= 20:
    print("Aconselho a parar de jogar")
elif soma == 21:
    print("Parabens vc venceu !!!")
else:
    print("Que pena vc perdeu")
print("Fim do programa")
