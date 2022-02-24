package com.company;

public class Pilha {

    private int tam_fixo;
    private char[] vet;
    private int topo;

    public Pilha(int tam_var) {
        this.tam_fixo = tam_var;
        this.vet = new char[tam_var];
        this.topo = -1;     // Vazio
    }


    public boolean vazia() {
        return this.topo == -1;
    }

    public boolean cheia() {
        return this.topo == this.tam_fixo - 1;
    }


    public boolean push(char elemento) {
        if (!this.cheia()) {
            this.vet[++this.topo] = elemento;
            return true;
        } else {
            System.out.println("Pilha cheia\n");
            return false;
        }
    }

    public char pop() {
        char c = 0;
        if (!this.vazia()) {
            c = this.vet[this.topo];
            --this.topo;
        } else {
            System.out.println("Pilha vazia");
        }

        return c;
    }
    
    public int tamanho(){   //Acessar o tamanho da pilha
        return this.tam_fixo;
    }

    public char elementos(){
        return vet[topo--];
    }

}
