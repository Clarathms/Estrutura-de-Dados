package com.company;

public class Q2 {
    public static void main() {
        //Cria vetor para ser transformado em ABB
        int vetor[] = {10,1,3,11,23,2,5,9,8,6};
        ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<>();

        //Construindo e mostrando na tela
        arvore.constroiArvore(vetor);
        arvore.mostra();
    }
}
