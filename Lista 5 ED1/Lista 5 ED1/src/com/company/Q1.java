package com.company;

public class Q1 {
    public static void main () {       // Método estático

        //Complexidade da questão: O(m*n)

        LDE l1 = new LDE();
        LDE l2 = new LDE();
        LDE l3 = new LDE(); // Interseção de L1 e L2

        // Inserir elementos na L1
        l1.insere(10);
        l1.insere(20);
        l1.insere(35);  // <-
        l1.insere(40);  // <-
        l1.insere(50);  // <-

        // Inserir elementos na L2
        l2.insere(15);
        l2.insere(25);
        l2.insere(35);
        l2.insere(40);
        l2.insere(50);

        System.out.println("Lista 1:" );
        l1.imprime();
        System.out.println("\nLista 2:" );
        l2.imprime();
        System.out.println("\nLista 3:" );
        l3.intersec(l1.prim , l2.prim);     // pega a partir dos últimos valores
        l3.imprime();
    }
}
