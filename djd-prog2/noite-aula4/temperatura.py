# str_temp = input("Digite a temperatura")
# temp = int(str_temp)

temp = int(input("Digite a temperatura"))

if temp < 15:
    print("Esta frio")
elif temp < 20:
    print("Agradavel")
elif temp > 40:
    print("Muito Calor")
else:
    print("Esta Calor")


print("Fim do programa")