package com.company;

public class Q3 {
    public static void main() {

        //Montando arvore e seus respectivos nos
        Arvbin<Integer> no1 = new Arvbin<Integer>(5);
        Arvbin<Integer> no2 = new Arvbin<Integer>(10);
        Arvbin<Integer> no3 = new Arvbin<Integer>(3);
        Arvbin<Integer> no4 = new Arvbin<Integer>(11);
        Arvbin<Integer> no5= new Arvbin<Integer>(32);

        no2.defineEsq(no4);
        no2.defineDir(no5);
        no1.defineEsq(no2);
        no1.defineDir(no3);

        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();

        // Migrando arvore binaria para ABB e printando na tela
        arvore.transformaBST(no1);
        arvore.mostra();

    }

}
