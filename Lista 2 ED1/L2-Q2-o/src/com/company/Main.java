package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FilaSimples fila = new FilaSimples (5);
        Fila f1 = new Fila(5);
        Fila f2 = new Fila(5);
        Fila filaMista = new Fila(5);


        Scanner scanner = new Scanner(System.in);


        int escolha, item;
        do
        {
            escolha = fila.menu();

            switch(escolha) {
                case 0: //Pula fora
                    break;
                case 1:     // Insere fila 1

                    System.out.println("Entre com o item para adicionar: ");
                    item = scanner.nextInt();
                    if ( ! f1.insere(item) )
                        System.out.println("Fila 1 cheia.");
                    break;


                case 2: //Remove fila 1
                    item = f1.remove();
                    if (item != Integer.MIN_VALUE)
                        System.out.println("Item " + item + " removido da fila 1.");
                    else
                        System.out.println("Fila vazia.");
                    break;




                case 4:     // Insere fila 2

                    System.out.println("Entre com o item para adicionar: ");
                    item = scanner.nextInt();
                    if ( ! f2.insere(item) )
                        System.out.println("Fila 2 cheia.");
                    break;



                case 5: //Remove fila 2
                    item = f2.remove();
                    if (item != Integer.MIN_VALUE)
                        System.out.println("Item " + item + " removido da fila 2.");
                    else
                        System.out.println("Fila 2 vazia.");
                    break;



                case 6: //imprime fila 2
                    System.out.println("Conteudo da fila 2:");
                    fila.imprime();
                    break;



                case 7: //imprime fila mista
                    filaMista.combinaFilas(f1, f2);
                    System.out.print("\n");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida");

                    break;
            }

        }while(escolha != 0);

        scanner.close();

    }
}
