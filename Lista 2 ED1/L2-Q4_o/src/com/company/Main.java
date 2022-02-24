package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TesteFilaSimples fila = new TesteFilaSimples(5);
        FilaDupla filaConvertida = new FilaDupla(5);
        TesteFilaDupla filaDupla = new TesteFilaDupla(5);

        Scanner scanner = new Scanner(System.in);
        int escolha, item;

        do
        {
            escolha = fila.menu();

            switch(escolha) {
                case 0:
                    //N�o faz nada
                    break;
                case 1:
                    System.out.println("Entre com o item para adicionar: ");
                    item = scanner.nextInt();
                    if ( ! fila.insere(item) )
                        System.out.println("Fila cheia.");
                    break;
                case 2:
                    item = fila.remove();
                    if (item != Integer.MIN_VALUE)
                        System.out.println("Item " + item + " removido.");
                    else
                        System.out.println("Fila vazia.");
                    break;
                case 3:
                    System.out.println("Conte�do da fila:");
                    fila.imprime();
                    break;
                case 4:
                    filaConvertida = Fila.Converte(fila);
                    break;
            }

        }while(escolha != 0);

        scanner.close();
















    }
}
