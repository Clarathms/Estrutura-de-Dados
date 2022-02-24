package com.company;

public class Q6 {

    // o método intersecao() percorre os conjuntos de forma paralela, possuindo complexidade O(n), em que n é
    // o tamanho do maior conjunto entre os dois que estão tendo seus elementos comparados
    // o método complementar() possui complexidade O(n), em que n é o tamanho do conjunto universo.
    // O conjunto universo é varrido juntamente do conjunto pelo qual o método foi chamado até que se descubra
    // todos os elementos que não fazem parte desse último.
    // Dessa forma, a complexidade do método calculaDeMorgan() é O(n), em que n é o tamanho do maior dos conjuntos perccoridos por um loop.

    public static void main() {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> conjUniverso = new ConjGenerico<>();
        ConjGenerico<Integer> deMorganIntersec = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(2);
        conj1.insere(4);
        conj1.insere(5);
        conj1.insere(8);

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(4);
        conj2.insere(6);
        conj2.insere(7);

        conjUniverso.insere(1);
        conjUniverso.insere(2);
        conjUniverso.insere(3);
        conjUniverso.insere(4);
        conjUniverso.insere(5);
        conjUniverso.insere(6);
        conjUniverso.insere(7);
        conjUniverso.insere(8);
        conjUniverso.insere(9);


        System.out.println("Conjunto 1:");
        conj1.imprime();

        System.out.println("Conjunto 2:");
        conj2.imprime();


        System.out.println("Conjunto universo:");
        conjUniverso.imprime();

        deMorganIntersec = deMorganIntersec.calculaDeMorgan(conj1, conj2, conjUniverso);

        System.out.println("Interseção dos complementos de A e B:");
        deMorganIntersec.imprime();
    }
}
