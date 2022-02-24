package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Processo P = new Processo(10);

        Scanner scanner = new Scanner(System.in);
        int escolha, item;

        do
        {
            escolha = P.menu();

            switch(escolha) {
                case 0:  // pula fora
                    break;
                case 1:
                    System.out.println("Entre com o item (inteiro) para adicionar: ");
                    item = scanner.nextInt();
                    if ( ! P.insere(item) )
                        System.out.println("Fila de processos ja esta cheia.");
                    break;
                case 2:
                    item = P.remove();
                    if (item != Integer.MIN_VALUE)
                        System.out.println("Item " + item + " removido.");
                    else
                        System.out.println("Fila vazia.");
                    break;
                case 3:
                    System.out.println("Elementos da fila:");
                    P.imprime();
                    break;
            }

        } while(escolha != 0);

        scanner.close();

    }
}
