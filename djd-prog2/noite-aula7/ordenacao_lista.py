lista = []

lista.append( int(input("Por favor digite o 1º numero: ")) )
lista.append( int(input("Por favor digite o 2º numero: ")) )
lista.append( int(input("Por favor digite o 3º numero: ")) )

print( lista )

# lista.sort()
# for i in range(len(lista) - 1):
#    if lista[i] == lista[i+1]:
#        print("tem numero repetido na lista")

if lista[0] >= lista[1] and lista[1] >= lista[2]:
    print(lista[2], lista[1], lista[0])
elif lista[0] >= lista[2] and lista[2] >= lista[1]:
    print(lista[1], lista[2], lista[0])
elif lista[1] >= lista[0] and lista[0] >= lista[2]:
    print(lista[2], lista[0], lista[1])
elif lista[1] >= lista[2] and lista[2] >= lista[0]:
    print(lista[0], lista[2], lista[1])
elif lista[2] >= lista[0] and lista[0] >= lista[1]:
    print(lista[1], lista[0], lista[2])
else:
    print(lista[0], lista[1], lista[2])
