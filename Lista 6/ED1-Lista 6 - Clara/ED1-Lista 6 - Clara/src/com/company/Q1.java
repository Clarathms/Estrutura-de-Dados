package com.company;

public class Q1 {
    // Complexidade: O(1) para ambos os métodos menorElemento() e maiorElemento() já que suas expressões ocorrem
    // durante um número constante, fixo toda vez que acontecem. Ou seja, usamos apenas os ponteiros que indicam
    // o início e o final do conjunto.

    public static void main() {

        Conj conj = new Conj();

        conj.insere(1);
        conj.insere(2);
        conj.insere(20);
        conj.insere(3);
        conj.insere(4);
        conj.insere(5);

        System.out.println("Elementos do Conjunto:");
        conj.imprime();

        System.out.println("Maior elemento do conjunto:");
        conj.maior();

        System.out.println("Menor elemento do conjunto:");
        conj.menor();
    }
}
