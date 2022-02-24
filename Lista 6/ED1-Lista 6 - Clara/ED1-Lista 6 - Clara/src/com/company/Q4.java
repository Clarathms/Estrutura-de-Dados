package com.company;

public class Q4 {
    // Complexidade: O(n), em que n é o tamanho do conjunto que chama o método.
    // Pois o método percorre td o conjunto procurando os elementos que pertencem ao conj1, mas
    // que não pertencem ao conj2
    public static void main() {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> diferenca;

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(8);
        conj1.insere(7);
        conj1.insere(2);

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(7);
        conj2.insere(9);
        conj2.insere(11);

        System.out.println("Conjunto 1:");
        conj1.imprime();
        System.out.println("Conjunto 2:");
        conj2.imprime();

        diferenca = conj1.diferencaConjunto(conj2);

        System.out.println("Diferença entre conjuntos:");
        diferenca.imprime();
    }
}
