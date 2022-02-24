package com.company;

public class ListaCircular extends Lista {


    /* Imprime todos os elementos da lista */
    public void imprime() {
        Elo p;
        p = prim;
        if (p != null) {
            do {
                System.out.print(p.dado + " ");
                p = p.prox;
            } while (p != prim);
        }
        System.out.println();
    }


    public void imprimeRecursivo() {
        System.out.println("Elementos da lista:");
        if (this.vazia())
            return;
        imprimeRecursivo(prim);
        System.out.println();
    }



    private void imprimeRecursivo(Elo p) {
        System.out.print(p.dado + " ");
        if (p.prox == prim)
            return;
        imprimeRecursivo(p.prox);
    }



    /* Insere elemento no fim da lista. */
    public void insere(int novo) {
        Elo p, q;
        q = new Elo(novo);
        p = prim;
        if (p != null) {
            /* Percorre at� alcancar o in�cio. */
            while (p.prox != prim) {
                p = p.prox;
            }
            p.prox = q;
            q.prox = prim;
        } else {
            prim = q;
            prim.prox = q;
        }
    }


    public boolean remove(int elem) {
        Elo p = null;
        Elo ant = null;
        if (prim == null) return false;
        for (p = prim; ((p.prox != prim) && (p.dado != elem)); p = p.prox)
            ant = p;
        /* Achou */
        if (p.dado == elem) {
            /* � o primeiro */
            if (p == prim) {
                /* � o �nico */
                if (prim == prim.prox) {
                    prim = null;
                } else {
                    /* Guarda o anterior ao primeiro */
                    for (ant = prim; (ant.prox != prim); ant = ant.prox) ;

                    ant.prox = prim.prox;
                    prim = prim.prox;
                }
            } else {
                /* No meio */
                ant.prox = p.prox;
            }
            /* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
             * o Garbage Collector ir� liberar essa mem�ria. */
            p = null;
            return true;
        } else
            return false;
    }



    public Lista separa(int n) {
        Lista l2 = new Lista();

        Elo p = prim;
        /* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
        do {
            /* Encontrou o elemento desejado. */
            if (p.dado == n)
                break;
            p = p.prox;
        } while (p != prim);
        /* Caso tenha percorrido a lista sem encontrar o elemento. */
        if (p.dado != n)
            return null;
        /* O "prim" da nova lista � o pr�ximo do elo apontado por p. */
        l2.prim = p.prox;
        /* O pr�ximo do elo apontado por p tem que apontar para o prim da
         * lista original. */
        p.prox = prim;
        Elo q;
        /* Anda at� o �ltimo elemento da lista 2. */
        for (q = l2.prim; q.prox != prim; q = q.prox) ;
        /* O pr�ximo do �ltimo elemento da lista 2 aponta para o primeiro. */
        q.prox = l2.prim;
        /* Retorna a nova lista constru�da. */
        return l2;
    }


    public int tamanho() {
        int tamanho = 0;
        Elo p;
        p = prim;

        if(p!=null) {
            do {
                p = p.prox;
                tamanho ++;
            } while(p != prim);
        }
        return tamanho;
    }

// QUESTÃO 2 - complexidade do método merde: O(n)

    public ListaCircular merge(ListaCircular l2) {

        int recebe1 = 0;
        int recebe2 = 0;
        int recebeTotal = 0;

        ListaCircular l3 = new ListaCircular();   // Como o parâmetro so pode ter l2, crio a l3 aqui

        // Condições caso as listas estejam vazias
        if(l2.prim == null){
            System.out.println("Lista 2 sem elementos");
            return this;
        }
        if(this.prim == null){      // Se refere a l1
            System.out.println("Lista 1 sem elementos");
            return l2;  // ou this?
        }

        Elo e1 = this.prim; // Primeiro elem da L1
        Elo e2 = l2.prim; // Primeiro elem da L2

        int tamanhoTotal = this.tamanho() + l2.tamanho();  // Tam l1 + tam l2

        do{
            if (recebe1 < this.tamanho() && e1 != null){
                l3.insere(e1.dado);     // l3 recebe valor de l1
                e1 = e1.prox;   // elo (e1) recebe próximo valor da lista
                ++recebe1 ; // recebe incrementa
            }
            if (recebe2 < this.tamanho() && e2 != null){
                l3.insere(e2.dado);     // l3 recebe valor de l2
                e2 = e2.prox;   // elo (e2) recebe próximo valor da lista
                ++recebe2 ; // recebe incrementa
            }
            recebeTotal = recebe1 + recebe2;

        } while (recebeTotal < tamanhoTotal);
        return l3;
    }

    //**************************************************************************

    // QUESTÃO 3 -> complxidade do método inverte lista = O(n)

    public ListaCircular inverteLista() {

        if (this.prim == null) {// Caso a lista esteja vazia
            System.out.println("Lista vazia");
            return null;
        }

        Elo ant = null; // Elemento anterior
        Elo dado = prim;    // El atual
        Elo prox;   // Prox elemento
        do {
            prox = dado.prox;   // proximo recebe atual linkado ao prox
            dado.prox = ant;
            ant= dado;
            dado = prox;
        } while (dado != (this.prim));

        //Ajusta as listas para que o último pont aponte para o primeiro
        this.prim.prox = ant;
        this.prim = ant;
        return null;
    }

//******************************************************************************


}
