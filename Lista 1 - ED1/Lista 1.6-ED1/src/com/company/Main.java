package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack pilha2 = new Stack();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira a frase: ");
        String frase = scanner.nextLine();

        fraseInvertida(frase);
    }

    public static void fraseInvertida(String frase) {

        Stack stack = new Stack ();
        //char letra = 0;
        //Vetor com a frase armazenada (divide)
        String[] fraseVetor = frase.split(" "); //separa cada palavra
        char recebe;

        for (String Frase : fraseVetor) {   //Recebe
            for (char letra: Frase.toCharArray()) {
                stack.push(letra);
            }

            do{
                recebe = (char) stack.pop();   //Tira
                System.out.println(recebe); //Troca a ordem
            }while (!stack.empty());

            System.out.print(" ");

        }
    }
}



