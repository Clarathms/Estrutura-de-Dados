package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int escolha;
        String item;

        //só pro menu
        TesteFilaSimples fila = new TesteFilaSimples(5);

        FilaPrioridades idosos = new FilaPrioridades(5);
        FilaPrioridades adultos = new FilaPrioridades(5);

        do {
            escolha = fila.menu();

            switch(escolha) {
                case 0:
                    //Não faz nada
                    break;
                case 1: // Insere idoso
                    System.out.println("Insira o nome do idoso na fila: ");
                    item = scanner.nextLine();
                    if ( !idosos.insere(item) )
                        System.out.println("Fila cheia.");
                    break;
                case 2: // Insere adulto
                    System.out.println("Insira o nome do adulto na fila: ");
                    item = scanner.nextLine();
                    if ( !adultos.insere(item) )
                        System.out.println("Fila cheia.");
                    break;
                case 3: //Imprime fila : quantos idosos + quantos adultos + ordem correta
                    System.out.println("Idosos na fila:");
                    idosos.imprime();
                    System.out.print("\n");

                    System.out.println("Adultos na fila:");
                    adultos.imprime();
                    System.out.print("\n");

                    System.out.println("Fila: ");
                    imprimeFilas(idosos,adultos);
                    System.out.print("\n");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida");
            }

        } while(escolha != 0);

        scanner.close();
    }

    public static void imprimeFilas(FilaPrioridades idosos, FilaPrioridades adultos) {
        FilaPrioridades idosoAdulto = new FilaPrioridades(idosos.tamanho + adultos.tamanho);

        while(!idosos.vazia() || !adultos.vazia()) {
            if(!idosos.vazia()) {
                idosoAdulto.insere(idosos.remove());
            } else if(!adultos.vazia()) {
                idosoAdulto.insere(adultos.remove());
            }
        }
        idosoAdulto.imprime();
    }
}
