# lista = ["F", "A", "T", "E", "C"]

lista = list("FATEC")
print(lista)
print(lista[0])
print(lista[0:3])

numeros = [i for i in range(1, 31)]
print(numeros)
print(numeros[1:6:2])

print(numeros[5:0:-2])

lista_numeros = [i for i in range(49, 0, -2)]
print(lista_numeros)

lista2 = [i for i in range(0, 50)]
print(lista2)

lista3 = lista2[50:0:-2]
print(lista3)

lista4 = lista2[::-2]
print(lista4)