package com.company;

public class Q2 {
    public static void main() {

        // Complexidade da questão: O(m*n) -> Pois intera duas listas

        ListaCircular l1 = new ListaCircular();
        ListaCircular l2 = new ListaCircular();
        ListaCircular l3 = new ListaCircular();         // Lista concatenada (alterna valores de l1 e l2)

        l1.insere(10);
        l1.insere(20);
        l1.insere(30);
        l1.insere(40);
        l1.insere(50);

        l2.insere(15);
        l2.insere(25);
        l2.insere(35);
        l2.insere(45);
        l2.insere(55);

        l3 = l1.merge(l2);

        System.out.println("Lista 1:");
        l1.imprime();
        System.out.println("\nLista 2:");
        l2.imprime();
        System.out.println("\nLista resultante:");
        l3.imprime();
    }
}
