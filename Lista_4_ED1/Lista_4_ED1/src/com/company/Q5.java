package com.company;
import java.util.Scanner;
public class Q5 {
    Scanner scan = new Scanner(System.in);

    public void input(){

        System.out.println("Digite uma frase para ser revertida, com as palavras revertidas:");
        String input2 = scan.nextLine();
        Q5.reverte(input2);
    }


    public static void reverte(String input2){
        ListaQ4 <String> lista = new ListaQ4<>();
        input2 = new StringBuilder(input2).reverse().toString(); // Reverte a frase!

        //Reverter as palavras:
        String[] palavras = input2.split(" ");
        for (String palavra : palavras) {
            for (char ch: palavra.toCharArray()) {
                lista.insere(Character.toString(ch));
            }
        }
        lista.imprime();
}





     
}
