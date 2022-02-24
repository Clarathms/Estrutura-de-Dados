package com.company;

public class Q4 {
    public static void main() {

        Arvbin<Integer> no1 = new Arvbin(5);
        Arvbin<Integer> no2 = new Arvbin(10);
        Arvbin<Integer> no3 = new Arvbin(3);
        Arvbin<Integer> no4 = new Arvbin(11);
        Arvbin<Integer> no5 = new Arvbin(32);

        no2.defineEsq(no4);
        no2.defineDir(no5);
        no1.defineEsq(no2);
        no1.defineDir(no3);

        System.out.println("Árvore Originalmente:");
        no1.mostra();

        no1.delete(19); // Como o valor não existe na árvore, imprime ela igual antes
        System.out.println("\n\nArvore depois de deletar valor");
        no1.mostra();

        no1.delete(3);  // Tirou o 3 na impressão
        System.out.println("\n\nArvore depois de deletar valor");
        no1.mostra();
    }

}
