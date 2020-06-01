lista1 = []
lista2 = ["Antonio", "Julia", "Maria", "Alberto"]
print(lista2)

lista3 = list()
print(lista3)

lista4 = list("Fatec")
print(lista4)

lista5 = ["Fatec"]
print(lista5)

lista6 = [1, 3, 5, 7, 9]
print(lista6)
print(lista6[2])

lista6[2] = 15
print(lista6)

a = 3
print(lista6[a])


lista7 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
print(lista7)

print(len(lista7))

lista8 = [0 for i in range(1000)]
print(lista8)

lista9 = [i for i in range(1000)]
print(lista9)

lista10 = [i for i in range(1, 1002, 2)]
print(lista10)

# for j in range(50):
#   print(lista10[j])

lista11 = [(i * 2) - 1 for i in range(1, 1001)]

