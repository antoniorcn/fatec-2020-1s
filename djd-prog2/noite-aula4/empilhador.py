print("Quem empilhou mais blocos".center(120, " "))
a = int(input("Quantos blocos o jogador A empilhou"))
b = int(input("Quantos blocos o jogador B empilhou"))
c = int(input("Quantos blocos o jogador C empilhou"))

if a > b >= c or a > c >= b:
    print("o jogador A empilhou mais blocos")
elif b > a >= c or b > c >= a:
    print("o jogador B empilhou mais blocos")
elif c > a >= b or c > b >= a:
    print("o jogador C empilhou mais blocos")
elif a == b and b > c:
    print("houve um empate no primeiro lugar entre jogadores A e B")
elif a == c and c > b:
    print("houve um empate no primeiro lugar entre jogadores A e C")
elif b == c and c > a:
    print("houve um empate no primeiro lugar entre jogadores B e C")
