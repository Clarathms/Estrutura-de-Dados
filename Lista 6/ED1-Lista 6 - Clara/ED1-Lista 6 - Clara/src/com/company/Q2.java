package com.company;

public class Q2 {
    public static void main() {
        // Complexidade: O(n), em que n é o tamanho do conjunto universo. O conjunto universo é varrido juntamente do conjunto
        // pelo qual o método foi chamado até que se descubra todos os elementos que não fazem parte desse último.

        ConjGenerico<Integer> Universo = new ConjGenerico<>();
        ConjGenerico<Integer> conj = new ConjGenerico<>();

        Universo.insere(1);
        Universo.insere(2);
        Universo.insere(3);
        Universo.insere(4);
        Universo.insere(5);
        Universo.insere(6);

        conj.insere(1);
        conj.insere(2);
        conj.insere(3);

        System.out.println("Conjunto Original:");
        conj.imprime();

        System.out.println("Conjunto Universal:");
        Universo.imprime();

        System.out.println("Conjunto Complementar:");
        conj.complementar(Universo);    // Fornece os valores complementares -> Do conj universal que estão fora do conj original

        conj.insere(7); // Add um valor ao conj original que o universal não possui
        System.out.println("Novo Conjunto Original:");
        conj.imprime();
        System.out.println("Conj Complementar + Exceçao");
        conj.complementar(Universo);
        // Retorna a exceçao
    }
    }
