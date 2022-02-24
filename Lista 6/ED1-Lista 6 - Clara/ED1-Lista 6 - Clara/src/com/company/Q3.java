package com.company;
public class Q3 {
    // Complexidade: O(n), em que n é o tamanho do conjunto (conj2) que contém ou não contém o outro conjunto (subconjunto conj1).
    // o método boolean subconjunto(ConjGenerico<T> conj2) percorre conj2 checando a existência de cada um dos elementos de conj1 nele.
    public static void main() {
        ConjGenerico <Integer> c1 = new ConjGenerico<>();
        ConjGenerico <Integer> c2 = new ConjGenerico<>();

        c2.insere(10);
        c2.insere(20);
        c2.insere(30);
        c2.insere(40);
        c2.insere(50);

        c1.insere(20);
        c1.insere(40);
        c1.insere(10);

        System.out.println("Conjunto 1:");
        c1.imprime();

        System.out.println("Conjunto 2:");
        c2.imprime();

        c1.subconjunto(c2);

        c1.insere(60);  // Não é mais subc de c2
        System.out.println("\nNovo c1:");
        c1.imprime();
        c1.subconjunto(c2);
    }
}
