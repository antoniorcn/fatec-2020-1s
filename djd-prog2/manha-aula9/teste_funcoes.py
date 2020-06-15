
a = 20


def cabecalho(nome_programa, autor="Anonymous", size=80):
    global a
    a = 10
    print("-" * size)
    print("-" * (size // 6),  "Programa: {}".format(nome_programa).center(size * 2 // 3 - 2), "-" * (size // 6))
    print("-" * (size // 6),  "Autor: {}".format(autor).center(size * 2 // 3 - 2), "-" * (size // 6))
    print("-" * size)


cabecalho(nome_programa="Teste de Funções", autor="Antonio Rodrigues")
cabecalho("Teste 2")

print(a)