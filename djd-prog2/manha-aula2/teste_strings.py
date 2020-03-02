nome = "Pindamonhangaba"
tam = len(nome)
print(tam)
print("Maiusculo: ", nome.upper())
print("Minusculo: ", nome.lower())
pos = nome.find("a")
print("A localizado em : ", pos)
qtd = nome.count("a")
print("Quantos As existem: ",qtd)

print("O quinto elemento é: ", nome[5])
print("Do quinto elemento ao 9º elemento: ", nome[5:10])

# print("Impares: ", nome[0:16:2])
print("Impares: ", nome[::2])

print("Inverso: ", nome[::-1])

