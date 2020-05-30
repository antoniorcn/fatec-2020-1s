lista = [3, 6, 7, 8, 10, 22, 34]

lista.append(20)

lista.extend([5, 7, 9, 11])

print( len(lista) )
print(lista)

print(lista.count(7))
lista.remove(7)
lista.remove(7)
print(lista)

print(lista.pop(5))
print(lista)

print(lista.index(20))

lista.insert(0, "Antonio")

outra_lista = lista.copy()

lista.insert(0, "Joao")

lista.reverse()

print("Lista: ", lista)
print("Outra Lista: ", outra_lista)