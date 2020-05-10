print("qual jogador empilhou mais blocos?".center(150," "))
a = int(input("Quantos blocos o jogador A empilhou ?: "))
b = int(input("Quantos blocos o jogador B empilhou ?: "))
c = int(input("Quantos blocos o jogador C empilhou ?: "))
if a==b==c:
    print("EMPATE!")
elif a==b and c < a:
    print("Jogador A e B empataram, jogador C ficou em ultimo")
elif a==b and c > a:
    print("Jogador A e B empataram, jogador C ficou em primiero")
elif a==c and b < a:
    print("Jogador A e C empataram, jogador B ficou em ultimo")
elif a==c and b > a:
    print("Jogador A e B empataram, jogador B ficou em primeiro")
elif b == c and c > a:
    print("Jogador B e C empataram, jogador A ficou em ultimo")
elif b == c and c < a:
    print("Jogador B e C empataram, jogador A ficou em primeiro")
elif b==c:
    print("Jogador B e B empataram, jogador A ficou em ultimo")
elif a > b and a > c:
    print("Jogadeor A venceu!!,")
elif b > a and b > c:
    print("Jogador B venceu!,")
elif c > a and c > b:
    print("Jogador C venceu!")
