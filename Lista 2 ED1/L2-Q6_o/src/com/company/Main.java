package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /*
        do {


        }while (n != 0);
        */


        System.out.println("Digite N :");
        int n = scanner.nextInt();

        converterBi(n);

        scanner.close();
    }

    //1 a n
    public static void converterBi (int n) {
        Fila sequencia = new Fila(n);
        int nb;
        System.out.println("Representações binárias de 1 até " + n + ":");

        //loop dos nrs binarios
        for (int i = 1; i <= n; i++) {
            nb = Integer.parseInt(Converte(i));
            sequencia.insere(nb);
        }
        System.out.println("\n");
    }

    //passa pra binario
    public static String Converte (int i) {

        //for(){

        int divisao = i;

        StringBuilder novoBinario = new StringBuilder();


        while (divisao > 0) {
            int bin = divisao % 2;
            novoBinario.append(bin);
            divisao = divisao >> 1;
        }
        // inverte a ordem e imprime
        //Chama toString
        System.out.print(novoBinario.reverse().toString() + " ");
        return novoBinario.reverse().toString();
    }
}