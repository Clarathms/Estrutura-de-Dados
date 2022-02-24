package com.company;

public class LDE {  // Lista duplamente encadeada

   protected Elo prim;

    protected static class Elo {
        protected int dado;
        protected Elo ant;
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

        public Elo(int elem, Elo antElem, Elo proxElem) {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public LDE() {
        prim = null;
    }

    /* Testa se a lista est� vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Insere elemento no in�cio da lista. */
    public void insere(int novo) {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    /* M�todo auxiliar para busca. */
    private Elo busca(int elem) {
        Elo p = null;

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox) ;

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public boolean remove(int elem) {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa se � ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;
        for (p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Imprime todos os elementos da lista em ordem reversa. */
    public void imprimeReversa() {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa:");

        p = prim;

        while (p != null) {
            ult = p;
            p = p.prox;
        }

        for (p = ult; p != null; p = p.ant) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }


    // QUESTÃO 1 -> Complexidade dos métodos instersec e verificaNulo -> O(n)

    public void intersec(Elo prim1, Elo prim2) {
        Elo elo1 = prim1;
        while (elo1 != null) {
            if (verificaNulo(prim2, elo1.dado)) {

                insere(elo1.dado);
            }
            elo1 = elo1.prox;
        }
    }


    public boolean verificaNulo(Elo prim, int dado) {
        Elo elo = prim;
        while (elo != null) {
            if (elo.dado == dado)
                return true;
            elo = elo.prox;
        }
        return false;
    }

//*****************************************************************

    // QUESTÃO 4
    public void trocaElos(int indiceElo1, int indiceElo2) {
        Elo elo1 = prim;
        Elo elo2 = prim;
        Elo recebe1 = prim;
        Elo recebe2 = prim;
        int p = 0;

        do{
            if(p == indiceElo1){    // Quando chegar no índice desejado, armazena na variável pra poder manipular depois
                recebe1 = elo1;
            }
            if(p == indiceElo2){    // Quando chega no segundo índice sai do loop e armazena seu valor, para poder manipular junto do índice 1
                recebe2 = elo2;
                break;
            }
            elo1 = elo1.prox;   // Armazena valores
            elo2 = elo2.prox;

            p++;    // Passa para o prox indice

        } while (p <= indiceElo2);

        int valor = recebe1.dado;   // Realiza a troca
        recebe1.dado = recebe2.dado;
        recebe2.dado = valor;
    }

    //********************************************************************
    // QUESTÃO 5:
    public boolean verificaIgualdadeRecursivo(Elo elo1, Elo elo2) {
        if (elo1 != null && elo2 != null) {
            return (elo1.dado == elo2.dado) && verificaIgualdadeRecursivo(elo1.prox, elo2.prox);
        }
        else if (elo1 == null && elo2 == null){
            return true;        }
        else {
            return false;
        }
    }

    public boolean verificaIgualdade(LDE l2) {
        if (verificaIgualdadeRecursivo(this.prim, l2.prim)){
            System.out.println("Listas Iguais");
            return true;
        }
        else{
            System.out.println("Listas Diferentes");
            return false;
        }
    }

//****************************************************************************************





    }




