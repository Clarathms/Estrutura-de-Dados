package com.company;

import java.util.Arrays;

public class Pilha {

    private char[] vetX;
    private int topo;
    private int n;  // Tamanho fixo
    private char[] vetY;
    private int topoY;

    public Pilha(int tam) { //construtor
        this.topo = -1;     // Indica que está vazio
        this.n = tam;   // Recebe tamanho definido na main
        this.vetX = new char [tam];
        this.vetY = new char[tam];
        this.topoY = -1;

    }

    // Ver se está cheia ou vazia:
    public boolean vazia() {
        return this.topo == -1;
    }

    public boolean cheia() {
        return this.topo == this.n - 1;
    }

    // Empilhar / Desempilhar
    public boolean push (char elemento) {
        if (!this.cheia()) {
            this.vetX[++this.topo] = elemento;
            return true;
        } else {
            System.out.println("A pilha já está cheia, não é possível inserir mais elementos\n");
            return false;
        }
    }

    public char pop() {
        ++this.topoY;
        if (!this.vazia()) {
            this.vetY[this.topoY] = this.vetX[this.topo];
            --this.topo;
        } else {
            System.out.println("A pilha não possui nenhum elemento");
        }
        return this.vetY[topoY];
    }

    public int tamanho () { // Pega o tamanho
        return this.n;
    }

//Imprimir cadeias
    @Override
    public String toString() {
                return  Arrays.toString(vetX) +
                        " C " + Arrays.toString(vetY) ;

    }
}


