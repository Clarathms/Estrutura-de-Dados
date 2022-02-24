package com.company;

public class Diretorio extends Arquivo {
    ListaQ4<Arquivo> arquivos = new ListaQ4<>();

    Diretorio(String nome) {
        super(nome);
    }

    public void insere(Arquivo arquivo) {   // Inserir um novo arquivo
        arquivos.insere(arquivo);
    }

    @Override
    public void imprime(int profundidade) {
        super.imprime(profundidade);

        if (arquivos.tamanho() == 0) {   // Pasta vazia
            System.out.println("\t".repeat(profundidade + 1) + "(Esse diretório está Vazio)");
            return;
        }
        for(var p = arquivos.prim; p != null; p = p.prox) {
            p.dado.imprime(profundidade + 1);
        }
    }
}