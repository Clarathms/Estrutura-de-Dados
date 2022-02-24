package com.company;
import java.util.Scanner;

public class Main {
    //*******************************  Questão 4  *****************************************************

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pilha pilha = new Pilha(20);

        // Input da frase
        System.out.println("Quantidade n de inteiros: ");
        int n = scan.nextInt();

         pilha.Pares(n);
    }
}
