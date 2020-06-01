numeros = []
numeros.append(int(input("Digite o 1º numero:")))
numeros.append(int(input("Digite o 2º numero:")))
numeros.append(int(input("Digite o 3º numero:")))

print(numeros)

if numeros[0] >= numeros[1] and numeros[1] >= numeros[2]:
    print(numeros[2], numeros[1], numeros[0])
elif numeros[0] >= numeros[2] and numeros[2] >= numeros[1]:
    print(numeros[1], numeros[2], numeros[0])
elif numeros[1] >= numeros[2] and numeros[2] >= numeros[0]:
    print(numeros[0], numeros[2], numeros[1])
elif numeros[1] >= numeros[0] and numeros[0] >= numeros[2]:
    print(numeros[2], numeros[0], numeros[1])
elif numeros[2] >= numeros[1] and numeros[1] >= numeros[0]:
    print(numeros[0], numeros[1], numeros[2])
else:
    print(numeros[1], numeros[0], numeros[2])
