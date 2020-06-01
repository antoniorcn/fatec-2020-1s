lista1 = [i for i in range(100)]
print(lista1)

lista2 = lista1[1:10:2]
print(lista2)

lista3 = lista1[100:89:-1]
print(lista3)

lista4 = lista1[30:41]
print(lista4)

lista5 = lista1[:89:-1]
print(lista5)

lista6 = lista1[::-1]
print(lista6)

for i in range(len(lista6)):
    print(lista6[i], end=", ")
    if i != 0 and i % 5 == 0:
        print("")

