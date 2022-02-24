package com.company;
public class PilhaGenerica <T> {

    private T[] elementos;
    private int tamanho;
    private int topo;

    //Construtores
    @SuppressWarnings("unchecked")
    public PilhaGenerica(int capacidade){
        this.elementos = (T[]) new Object[capacidade]; //Vetor como objeto que recebe T
        this.tamanho = capacidade;
        this.topo = -1;
    }

    public PilhaGenerica(){
        this(10);
    }

    // Verif se está vazia ou cheia

    public boolean estaCheia(){
        return topo == tamanho - 1 ? true : false;
    }

    public boolean estaVazia(){
        return topo == -1 ? true : false;
    }


    // Push e pop
    protected boolean adiciona(T elemento) {
        if (!this.estaCheia()){
            this.elementos[++topo] = elemento;
            return true;
        }
        return false;
    }

    protected T remove(){
        T elemento = null;
        if (!this.estaVazia()) {
            this.elementos[topo--] = elemento;
            return elemento;

        }
        else
            return null;

    }

    // Tamanho e impressão

    public int tamanho(){
        return this.tamanho;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i=0; i<this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho>0){
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }


}
