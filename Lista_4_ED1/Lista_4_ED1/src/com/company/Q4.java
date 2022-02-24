package com.company;
import java.util.Scanner;
public class Q4 {
    Scanner scan = new Scanner(System.in);

    public void input (){
        System.out.println("Digite uma frase para ser dividida:");
        String input = scan.nextLine();
        Q4.frase(input);
    }

    // O(n)
    public static void frase(String input){ // Separa os tokens
        ListaQ4<String> lista = new ListaQ4<>();

        String[] tokens = input.split(" ");

        System.out.println("\nTokens da frase:");
        for (String item : tokens) {
            System.out.println(item);
            lista.insere(item);
        }
        System.out.println("\nFrase inteira na lista:");
        String frase = remontaFrase(lista);
        System.out.println(frase);
        System.exit(0);
    }

// Remonta frase
public static String remontaFrase (ListaQ4<String> lista) {
        String frase = "";
        for(ListaQ4.Elo p = lista.prim; p!= null; p = p.prox){
            frase = frase + p.dado + " ";
        }
        return frase;
    }

}
