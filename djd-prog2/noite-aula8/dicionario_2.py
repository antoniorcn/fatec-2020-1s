link = {"hp": 100, "mp": 100, "estamina": 100, "vidas": 5}

print( len(link) )

print(link)

del link['hp']

print(link)

if 'mp' in link:
    print("O link tem MP")
else:
    print("Link não tem mais MPs")

items = link.items()
print(items)

print( link.keys() )

print( link.values() )