package com.company;
import java.util.Scanner;

public class Q3 {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        ListaGenericaOrdenada<String> lista = new ListaGenericaOrdenada<>();

        int valor;
        do {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Inserir nome");
            System.out.println("0. Sair.\n");

            System.out.println("Opção escolhida: ");
            valor = scanner.nextInt();

            switch(valor) {
                case 0 :
                    break;
                case 1 :
                    System.out.println("Entre com o nome: ");
                    String nome = scanner.next();
                    lista.insere(nome);

                    System.out.println("Lista de nomes em ordem alfabética:\n");
                    lista.imprime();
                    break;

                default :
                    System.out.println("Opção Inválida");
                    break;
            }
        } while(valor != 0);
    }
}
