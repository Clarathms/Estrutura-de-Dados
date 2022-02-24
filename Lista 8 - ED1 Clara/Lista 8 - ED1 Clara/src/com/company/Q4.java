package com.company;

public class Q4 {
    public static void main() {

        // Criando ABB e colocando valores
        ArvBinBusca<Integer,Integer> arvore = new ArvBinBusca<>();
        arvore.put(3, 3);
        arvore.put(4, 4);
        arvore.put(2, 3);
        arvore.put(1, 1);
        arvore.put(5, 5);
        arvore.put(7, 7);
        arvore.put(9, 9);

        //Antes da remocao e depois -> printando na tela
        System.out.println("Original: ");
        arvore.mostra();
        System.out.println();
        System.out.println();

        System.out.println("Removendo intevalo: ");
        System.out.println(arvore.removeForaIntervalo(1, 9));	// tentando remover
        arvore.mostra();
        System.out.println();
        System.out.println();

        System.out.println("Removendo intevalo: ");
        System.out.println(arvore.removeForaIntervalo(3, 4));	// removendo
        arvore.mostra();

    }
}
