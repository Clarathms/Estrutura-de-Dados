package com.company;


public class Lista
{
    protected Elo prim;
    private int t ;  // t = tamanho

    protected class Elo {
        protected int dado;
        protected Elo prox;

        public Elo() {
            prox = null;
        }


        public Elo(int elem) {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo proxElem) {
            dado = elem;
            prox = proxElem;
        }
    }

    public Lista() {
        prim = null;
        this.t = 0;  // Acesso a variável privada t e atribuo valor
    }


    public boolean vazia()
    {
        return prim == null;
    }





    public void insere(int novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
        setT(t+1);  // Acrescenta 1 ao valor de t
    }





    public boolean busca(int elem) {
        Elo p;
        for(p = prim; p != null; p = p.prox) {
            if(p.dado == elem)
                return true;
        }
        return false;
    }






    public boolean buscaRecursiva(int elem) {
        if(this.vazia())
            return false;
        return buscaRecursiva(elem, prim);
    }





    private boolean buscaRecursiva(int elem, Elo p) {
        if(p == null)
            return false;

        if(p.dado == elem)
            return true;

        return buscaRecursiva(elem, p.prox);
    }





    public boolean remove(int elem) {
        Elo p;
        Elo ant = null;
        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;

        if (p == null)
            return false;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;
        p = null;
        setT(t-1);      // Decrementa 1 em t
        return true;
    }




    public void imprime() {
        Elo p;
        for(p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }
        System.out.println();
    }




    public void imprimeRecursivo() {
        System.out.println("Elementos da lista:");

        if(this.vazia())
            return;
        imprimeRecursivo(prim);
        System.out.println();
    }



    private void imprimeRecursivo(Elo p) {
        if(p == null)
            return;
        System.out.print(p.dado + " ");
        imprimeRecursivo(p.prox);
    }



    public int tamanho(){       // Questão 1
        return t;
    }

    public int tamanhoRecursivo() {
        if(this.vazia())
            return 0;
        return tamanhoRecursivo(prim);
    }



    private int tamanhoRecursivo(Elo p) {
        if(p == null)
            return 0;
        return 1 + tamanhoRecursivo(p.prox);
    }

    public int max() {
        if(this.vazia())
            return 0;
        Elo p;
        int maior = Integer.MIN_VALUE;
        for(p = prim; p != null; p = p.prox) {
            if(maior < p.dado)
                maior = p.dado;
        }
        return maior;
    }

    public int maxRecursivo() {
        if(this.vazia())
            return 0;
        return maxRecursivo(prim);
    }

    private int maxRecursivo(Elo p) {
        if(p == null)
            return Integer.MIN_VALUE;
        int maior = maxRecursivo(p.prox);

        if(maior < p.dado)
            maior = p.dado;

        return maior;
    }

    public Lista separa(int n) {
        Lista l2 = new Lista();
        Elo p;

        for(p = prim; (p != null) && (p.dado != n); p = p.prox);
        if(p == null)
            return null;
        l2.prim = p.prox;
        p.prox = null;
        return l2;
    }

    public static Lista concatena(Lista l1, Lista l2) {
        Elo p;

        if(l1.prim == null) {
            l1.prim = l2.prim;
        }
        else {
            for(p = l1.prim; p.prox != null; p = p.prox);
            p.prox = l2.prim;
        }
        l2.prim = null;
        return l1;
    }

    public static Lista constroi(int[] v, int n) {
        Lista l = new Lista();
        Elo p, ult;
        ult = null;

        for(int i = 0; i < n; i++) {
            p = l.new Elo(v[i]);
            if(l.prim == null) {
                l.prim = p;
                ult = p;
            }
            else {
                ult.prox = p;
                ult = p;
            }
        }
        return l;
    }

    // Get e Set para t

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public static Elo intercala (Elo l1,Elo l2) {   // Complexidade O(1)

        // Se valores de l1/l2 forem nulos:
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.dado < l2.dado) {  // Ordem dos tamanhos para colocar na ordem
            l1.prox = intercala(l1.prox, l2);
            return l1;
        } else {
            l2.prox = intercala(l2.prox, l1);
            return l2;
        }
    }

}