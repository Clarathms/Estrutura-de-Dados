package com.company;

public class ListaQ4 <T>{       // Ficou uma lista geral que será usada em outras questões
    protected Elo<T> prim;

    protected static class Elo <T>{
        protected T dado;
        protected Elo<T> prox;

        public Elo(T elem) {
            dado= elem;
            prox= null;
        }
    }

    public ListaQ4() {prim = null;}

    public void insere(T novo) {
        Elo p, q;
        Elo ant = null;
        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado != novo)); p = p.prox)
            ant = p;
        if (ant == null)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
    }

    public void imprime() {
        Elo p;
        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }
        System.out.println();
    }

    public int tamanho() {
        int tamanho = 0;
        Elo p = prim;
        while(p != null){
            tamanho++;
            p = p.prox;
        }
        return tamanho;
    }

    // Para a quest 7
    public boolean busca(T elem) {
        Elo p;
        for(p =prim; p != null; p= p.prox){
            if(p.dado.equals(elem)){
                return true;
            }
        }
        return false;
    }

    public void remove(T elem) {
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;
        if (p == null)
            return;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;
    }

}
