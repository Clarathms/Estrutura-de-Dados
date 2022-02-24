package com.company;

//Ordem de complexidade de cada método da Q1: O(n) com n sendo os nós
//Ordem de complexidade da Q1: O(n)

public class Q1 {
    public static void main() {

        Arvbin<Integer> no1 = new Arvbin(9);
        Arvbin<Integer> no2 = new Arvbin(1);
        Arvbin<Integer> no3 = new Arvbin(55);

        no1.defineEsq(no2);
        no1.defineDir(no3);
        System.out.println("Pre ordem");
        no1.imprimePreOrdem();
        System.out.println();
        System.out.println("Pos ordem");
        no1.imprimePosOrdem();
        System.out.println();
        System.out.println("Em ordem");
        no1.imprimeEmOrdem();
    }
}
