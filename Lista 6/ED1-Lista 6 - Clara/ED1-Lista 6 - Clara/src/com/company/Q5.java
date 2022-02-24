package com.company;

public class Q5 {

    // Complexidade: O(n), linear, em que n é o tamanho da menor lista entre as duas. A comparação
    // entre as duas listas para quando se encontra um elemento diferente em uma delas.

    public static void main() {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(7);
        conj1.insere(9);

        System.out.println("Conjunto 1:");
        conj1.imprime();

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(7);
        conj2.insere(9);


        System.out.println("Conjunto 2:");
        conj2.imprime();

       conj1.igualdadeConjuntos2(conj2);

        // Testar pro caso das listas serem diferentes:
        conj2.insere(12);
        conj1.igualdadeConjuntos2(conj2);
    }
}
