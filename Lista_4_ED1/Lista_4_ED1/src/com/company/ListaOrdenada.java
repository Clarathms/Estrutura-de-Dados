package com.company;


public class ListaOrdenada extends Lista {


    public void insere(int novo) {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
            ant = p;
        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
    }


    public boolean remove(int elem) {
        Elo p;
        Elo ant = null;
        for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
            ant = p;
        if ((p == null) || (p.dado != elem))
            return false;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;
        return true;
    }
}