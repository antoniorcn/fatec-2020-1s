nome = "Antonio Rodrigues Carvalho Neto"
pos = nome.find(' ')
tamanho = len(nome)
print("Posicao do espaco: ", pos)
print("Tamanho: ", tamanho)
sobrenome = nome[pos + 1:tamanho]
print(sobrenome)