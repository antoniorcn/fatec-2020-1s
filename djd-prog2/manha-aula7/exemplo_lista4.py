lista1 = [1, 3, 5, 7, 9, 11]
print(lista1)
lista1.insert(3, 6)
print(lista1)

lista1 = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
          'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'z']
print(lista1)

lista1.insert(10, 'k')
print(lista1)

pos = lista1.index('x')
lista1.insert(pos, ' ')
# lista1[pos] = 'w'
print(lista1)

lista1.append(" ")
print(lista1)

# pos = lista1.index("k")
# lista1[pos] = None

lista1.remove("k")
print(lista1)

pos = lista1.index("u")
print(pos)

letra = lista1.pop(pos)
print("Foi removida a letra : ({})". format(letra))
print(lista1)

lista1.extend(['h', 'h', 'h'])

qtd = lista1.count('h')
print(lista1)
print(qtd)

# str1 = " - "
# str2 = "Novo"
# str3 = str1.join(str2)
# print(str3)

lista2 = lista1.copy()  # lista1[::]
lista1.remove("g")
lista2.reverse()
print("Lista 1: ", lista1)
print("Lista 2: ", lista2)

