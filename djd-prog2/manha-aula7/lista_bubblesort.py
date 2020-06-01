from random import randint
# numeros = [i for i in range(100, 1, -1)]
numeros = [randint(0, 200) for i in range(5)]
print(numeros)
print(len(numeros))

# print(numeros[99])

for j in range(len(numeros)):
    for i in range(len(numeros) - 1):
        if numeros[i] > numeros[i + 1]:
            temp = numeros[i + 1]
            numeros[i + 1] = numeros[i]
            numeros[i] = temp

print(numeros)
