from random import randint

lista = [randint(1, 100) for i in range(100)]

print(lista)

def f1( item ):
    if (item == 1) or (item == 11) or (item == 21):
        return True
    else:
        return False

print(list(filter( f1, lista )))
lista.sort(reverse=True)
print(lista)