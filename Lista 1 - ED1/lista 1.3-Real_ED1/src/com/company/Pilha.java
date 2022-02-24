package com.company;

public class Pilha<T> {

    protected T[] elementos;      // Um unico vetor com 10 espaços no total
    private int topo;           // Topo da pilha 1 - de 0 a 9
    protected int topo2;          //topo da pilha 2 - de 9 a 0  -> LIFO (sempre vai tirar)

    public Pilha(int i) {
    this.elementos = (T[]) new Object[i];
    this.topo = -1;
    this.topo2 = 9;

    }

//*************** Pilha 1 **********************

    //Verif se está cheia ou vazia
    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return this.topo == this.elementos.length - 1;
    }

        //Empilhar
    public boolean push(T e) {
        if (!estaCheia()) {
            topo++;
            elementos[topo] = e;
            return true;
        }
        return false;
    }

    //Desempilhar
    public T pop() {
        if (!estaVazia()) {
            return elementos[topo--];
        }
        return null;

    }

    public int tamanho() {
        return this.elementos.length;
    }

    //***************************** Pilha 2 ******************************


    //Verif se está cheia ou vazia
    public boolean estaCheia2() {
        return topo2 == -1;
    }

    public boolean estaVazia2() {
        return this.topo2 == this.elementos.length - 1;
    }


    //Empilhar pilha 2
    public boolean pop2() {
        topo2++;
        return true;
    }


    //Desempilhar pilha 2
    public boolean push2(T e) {

        this.elementos[topo2] = e;
        topo2--;

        return true;
    }

//**************** Verif se estourou ******************


    public boolean Estouro (){

            if (topo > 9 || topo2 < 0 || topo == topo2){
                return true;
            }
            else
        return false;
    }

//************* Imprimir pilhas ***************

    @Override
    public String toString() {

        StringBuilder sb2 = new StringBuilder("\nVetor Total: [");

        for (int i = 0; i <= this.topo2; i++) {
            sb2.append(this.elementos[i]);
            if (i < this.topo2) {
                sb2.append(", ");
            }
        }

        sb2.append("]");
        return sb2.toString();
    }
}

