package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Definir o tamanho do vetor
        Pilha pilha = new Pilha(10);

        System.out.println("Cadeia de caracteres do vetor X (A/B):");
        String caract = scan.nextLine();

        // Armazenar cadeia separadamente no vetor de X
        char x;
        for (int i = 0; i < caract.length(); ++i) {
            x = caract.charAt(i);
            pilha.push(x);
        }

        // Inverter a pilha + vetor Y recebe ela
        char y;
        System.out.println("O Vetor Y é: ");
        while (!pilha.vazia()) {
            y = pilha.pop();
            System.out.println( "" + y +"");

        }

        System.out.println("\n A forma x C y ficará: ");
        System.out.println(pilha.toString());

    }
}
