package com.company;

public class Q4 {
    public static void main() {

        //Complexidade da questão é O(m*n)
        LDE lista = new LDE();

        lista.insere(10);
        lista.insere(20);
        lista.insere(30);
        lista.insere(40);
        lista.insere(50);

        System.out.println("Lista com os elos trocados:");

        // 20 vai pra onde tava o 40

        lista.trocaElos(1,3);
        lista.imprimeReversa();



    }
}
