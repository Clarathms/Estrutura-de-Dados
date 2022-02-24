package com.company;

public class Q2 {

    public static void main() {

        ListaOrdenada l1 = new ListaOrdenada();  // Lista 1
        ListaOrdenada l2 = new ListaOrdenada();     // Lista 2
        ListaOrdenada lFinal = new ListaOrdenada();     // Lista resultante de intercalar l1 e l2

        l1.insere(10);
        l1.insere(20);
        l1.insere(30);

        l2.insere(5);
        l2.insere(15);
        l2.insere(35);

        System.out.println("Elementos da Lista 1:");
        l1.imprime();

        System.out.println("\nElementos da Lista 2:");
        l2.imprime();

        System.out.println("\nLista intercalada resultante:\n");
        lFinal.prim = ListaOrdenada.intercala(l1.prim,l2.prim);
        lFinal.imprime();



    }

}
