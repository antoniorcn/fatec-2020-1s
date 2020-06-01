lista1 = [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144]
print(lista1)

lista1.append(89 + 144)
print(lista1)

lista2 = [377, 610, 987, 1597]
lista1.extend(lista2)
print(lista1)

tamanho = len(lista1)
print(tamanho)

nome = "Antonio Rodrigues"
lista3 = list(nome)
print(lista3)
lista_posicoes = []
encontrado = True
pos = -1
while encontrado:
    try:
        pos = lista3.index("i", pos + 1)
        lista_posicoes.append(pos)
        print(pos)
    except:
        encontrado = False
        print("Nao encontrou mais ocorrencias")

print(lista_posicoes)
