package com.company;

public class Q3 {
    public static void main () {

        //Complexidade da questão é O(n)

        ListaCircular listaInvertida = new ListaCircular();

        listaInvertida.insere(10);
        listaInvertida.insere(20);
        listaInvertida.insere(30);
        listaInvertida.insere(40);
        listaInvertida.insere(50);
        listaInvertida.insere(60);

        System.out.println("Lista Circular original:");
        listaInvertida.imprime();

        System.out.println("\nLista Circular invertida:");
        listaInvertida.inverteLista();
        listaInvertida.imprime();
    }
}
