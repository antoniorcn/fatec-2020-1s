from random import randint
lista = [randint(1, 100) for _ in range(1000)]

print(lista)

for j in range(len(lista)):
    for i in range(len(lista) - 1):
        if lista[i] > lista[i + 1]:
            print(f'Trocar valor da lista[{i}] = {lista[i]} com lista[{i+1}] {lista[i+1]}')
            temp = lista[i + 1]
            lista[i + 1] = lista[i]
            lista[i] = temp

print(lista)