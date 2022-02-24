package com.company;

public class Q5 {

    public static void main() {
        //Montando ABB e seus respectivos nos
        ArvBinBusca<Integer,Integer> arvore = new ArvBinBusca<>();

        arvore.put(3, 3);
        arvore.put(4, 4);
        arvore.put(2, 3);
        arvore.put(1, 1);
        arvore.put(5, 5);
        arvore.put(7, 7);
        arvore.put(9, 9);
        System.out.println("Arvore:");
        arvore.mostra();
        System.out.println();

        //Pegando nos para encontrar seus ancestrais
        var no = arvore.getNo(5); // primeiro no
        var no2 = arvore.getNo(9);  // segundo no
        // var no3... aaaaa

        System.out.print("Buscando ancestral em comum de ");
        arvore.printNo(no);
        System.out.print(" e ");
        arvore.printNo(no2);
        System.out.print(": ");

        // Imprime anc em c
        arvore.printNo( arvore.obtemAncestralComum(no, no2) );

    }


}
