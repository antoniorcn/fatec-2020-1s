opcao = "X"
# opcao != "J" and opcao != "O" and opcao != "S"
# not (opcao == "J" or opcao == "O" or opcao == "S")
while opcao != "S":
    while not (opcao == "J" or opcao == "O" or opcao == "S"):
        print("Menu".center(120, " "))
        print("J - Jogar".center(120, " "))
        print("O - Opções".center(120, " "))
        print("S - Sair".center(120, " "))
        opcao = input("Faça sua escolha J, O ou S")

    print("Voce selecionou a opção ", opcao)
    if opcao != "S":
        opcao = "X"
print("Fim do jogo")