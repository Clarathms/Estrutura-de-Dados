package com.company;

public class Q5 {
   public static void main() {

       //Como itera listas diferentes, a complexidade da questão é O(m*n)

        LDE l1 = new LDE();
        LDE l2 = new LDE();
        LDE l3 = new LDE();

        // Criação / comparação de listas
       l1.insere(10);
       l1.insere(20);
       l1.insere(30);
       l1.insere(40);
       l1.insere(50);


       l2.insere(10);
       l2.insere(20);
       l2.insere(30);
       l2.insere(40);
       l2.insere(50);

       // Lista diferente
       l3.insere(45);
       l3.insere(68);
       l3.insere(97);
       l3.insere(44);
       l3.insere(71);

       System.out.println("Lista 1:");
       l1.imprime();
       System.out.println("\nLista 2:");
       l2.imprime();
       System.out.println("\nLista 3:");
       l3.imprime();

       System.out.println("\nLista 1 e 2:");
        l1.verificaIgualdade(l2);

       System.out.println("\nLista 1 e 3:");
       l1.verificaIgualdade(l3);

       System.out.println("\nLista 2 e 3:");
       l2.verificaIgualdade(l3);

    }



}
