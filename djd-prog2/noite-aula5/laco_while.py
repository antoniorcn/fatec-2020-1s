opcao = ""
while opcao != "S":
    print("M E N U  J O G O")
    print("J - Jogar")
    print("O - Opções")
    print("S - Sair")
    opcao = input("Por favor escolha sua opção (J, O ou S)").upper()
    if len(opcao) > 1:
        print("Opção invalida")
        continue

    if opcao == "J":
        print("Você está jogando")
    elif opcao == "O":
        print("Você está no menu de opções")
    elif opcao == "S":
        print("Tchau")
else:
    print("Você saiu do jogo")

print("Fim do programa")