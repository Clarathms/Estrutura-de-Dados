package com.company;

public class Arquivo {
    protected String nomeArquivo;

    public Arquivo(String nome) {
        this.nomeArquivo = nome;
    }

    public void imprime(int profundidade) {
        System.out.println("\t".repeat(profundidade) + nomeArquivo);
    }

}
