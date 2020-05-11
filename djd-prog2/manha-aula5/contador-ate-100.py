print("Contador".center(120, " "))
# n = 1               # Inicialização
# while n <= 100:     # Condição
#     print(n)
#     n = n + 1       # Passo

# for n in range(1, 101, 1):
#     print(n)

# for i in [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20]:
#     print("Elemento: ", i)

for i in range(0, 2001, 2):
    # if i == 1998:
    #     continue
    print(i)
    if i == 304:
        break
else:
    print("Laço terminado normalmente")


print("Fim do programa")