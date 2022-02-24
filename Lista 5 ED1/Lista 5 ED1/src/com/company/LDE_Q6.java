package com.company;

public class LDE_Q6 {
    protected Elo prim;

    protected static class Elo {
        protected int dado;
        protected LDE.Elo ant;
        protected Elo prox;

        public Elo() {
            ant = null;
            prox = null;
        }

        public Elo(int elem) {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, LDE.Elo antElem, Elo proxElem) {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public LDE_Q6() {
        prim = null;
    }

    public void insere(String nome, int novo) {
        Elo p, q;       // Define ordem para o custo de cada chamada
        p = new Elo(novo);
        Elo ant = null;
        q = new Elo(novo);

        p.prox = prim;
        p.ant = null;

        for (p = prim; ((p != null) && (p.dado > novo)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;

        System.out.println( nome +", custo: " + novo);
    }


    public void imprime() {
        Elo p;

        System.out.println("Ordem com base do maior ao menor custo:\n");

        for(p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + "\n ");
        }

        System.out.println();
    }
}
