package com.company;

public class Q6 {
    public static void main() {

        Arvbin<Integer> no1 = new Arvbin(1);
        Arvbin<Integer> no2 = new Arvbin(1);
        Arvbin<Integer> no3 = new Arvbin(2);
        Arvbin<Integer> no4 = new Arvbin(2);
        Arvbin<Integer> no5 = new Arvbin(5);
        Arvbin<Integer> no6 = new Arvbin(6);

        no1.defineEsq(no3);
        no2.defineDir(no4);
        no5.defineEsq(no1);
        no5.defineDir(no2);

        // Output das arvores simetricas
        System.out.println("Árvore:");
        no5.mostra();

        System.out.println("\n\nArvore é simetrica? ");
        System.out.println(no5.eSimetrica());   // Vdd

        no3.defineDir(no6);
        System.out.println("\nNova árvore:");
        no5.mostra();

        System.out.println("\n\nArvore é simetrica? ");
        System.out.println(no5.eSimetrica());   // Falso
    }

}
