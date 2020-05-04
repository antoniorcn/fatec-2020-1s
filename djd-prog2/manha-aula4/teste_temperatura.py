print("Medidor de temperatura")

temp = int(input("Digite a temperatura ambiente"))
if temp > 40:
    print("Esta muito calor")
elif temp >= 25 and temp <= 40:
    print("Esta calor")
elif temp >= 15 and temp < 25:
    print("Está agradável")
else:
    print("Esta frio")
#
# if temp > 40:
#     print("Esta muito calor")
# else:
#     if temp >= 25 and temp <= 40:
#         print("Esta calor")
#     else:
#         if temp >= 15 and temp < 25:
#             print("Está agradável")
#         else:
#             print("Esta frio")

# Maior que 40º é muito calor
# De 25 a 40º é Calor
# De 15 a 25º Temperatura agradável
