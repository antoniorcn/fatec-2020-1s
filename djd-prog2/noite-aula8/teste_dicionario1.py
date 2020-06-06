from random import randint
# link = {}
# link['armardura'] = "Couro"
# link['arma'] = "Espada Bronze"
# link['protecao'] = "Escudo de Ferro"
# link['amuletos'] = ["pé de coelho", "proteção", "velocidade", "força"]
# link['acessorios'] = ["botas"]
# link['mp'] = 100
# link['estamina'] = 100
# link['hp'] = 100
# link['vidas'] = 5

link = {"hp": 100, "mp": 100, "estamina": 100, "vidas": 5}

while True:
    print("Vidas: {}  HP: {}   MP: {}  Etamina: {} ".format(
        link['vidas'], link['hp'], link['mp'], link['estamina']))

    print("-"*100)
    print("O P Ç Õ E S".center(100))
    print("-" * 100)
    print("L - Lutar")
    print("F - Fugir")
    print("M - Magia")
    print("-" * 100)
    opcao = input("Escolha a opção (L, F ou M)")

    if (opcao.upper() == "L"):
        link['hp'] -= randint(0, 50)
    elif (opcao.upper() == "F"):
        link['estamina'] -= randint(0, 50)
    elif (opcao.upper() == "M"):
        link['mp'] -= randint(0, 50)