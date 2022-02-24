import matplotlib.pyplot as plt

# 1) Abre o arquivo com o nome
# 2) Percorre cada linha do arquivo e pega os 3 valores do arquivo txt
# 3) Salva cada valor no array de valores
# 4) Usa os valore para plotar os gráficos e configurar seus campos
# 5) Salva o grafico com o nome da função na pasta gráficos
# 6) Fecha a plotagem e inicia o passo 1 (para cada função)

title = "inserir"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()
#************************************************************
title = "remover"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()

title = "buscar"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()

title = "eTriangInf"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()


title = "eTriangSup"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()



title = "eSimetrica"

f = open("tempos/" + title + ".txt","r")


temposEstatica  = []
temposEncadeada =  []
dims = []

for line in f.readlines():
    tempoEstatica, tempoEncadeada, dim = line[0:-1].split(',')
    temposEstatica.append(float(tempoEstatica))
    temposEncadeada.append(float(tempoEncadeada))
    dims.append(float(dim))

# plot lines
plt.plot(dims, temposEstatica, label = "Matriz Estática")
plt.plot(dims, temposEncadeada, label = "Matriz Encadeada")
plt.xlabel('Tamanho Matriz')
plt.ylabel('Tempo (ns)')
plt.title(title)
plt.legend()

plt.savefig("graficos/" + title + ".png")
plt.close()
