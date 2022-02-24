package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        Pilha pilha = new Pilha (5);

        System.out.println("Entre com 5 caracteres:\n ");

        char c;
        for (int i=0; i< pilha.tamanho();i++){

            System.out.println("Caracter " + (i+1) + ":");
             c = scan.next().charAt(0);
            pilha.push(c);
        }

        System.out.println("\nElementos x D y:\n");
        for (int i=0; i< pilha.tamanho();i++) {
            while (!pilha.vazia()) {
               char e = pilha.pop();

               System.out.print(  e + " D ");
            }
        }
    }
}
