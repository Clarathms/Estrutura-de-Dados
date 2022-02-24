package matriz;

import java.util.Scanner;

public class TesteMatriz {

    private static int apresentaMenu() {
        int escolha;
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------\n");
        System.out.println("Selecione uma opcao:\n");
        System.out.println("1. Insere elemento (no. inteiro) na matriz\n");
        System.out.println("2. Remove elemento (no. inteiro) da matriz\n");
        System.out.println("3. Busca elemento (no. inteiro) na matriz\n");
        System.out.println("4. Imprime elementos da matriz.\n");
        System.out.println("5. Verifica se é matriz vazia.\n");
        System.out.println("6. Verifica se é matriz diagonal.\n");
        System.out.println("7. Verifica se é matriz linha.\n");
        System.out.println("8. Verifica se é matriz coluna.\n");
        System.out.println("9. Verifica se é matriz triangular inferior.\n");
        System.out.println("10. Verifica se é matriz triangular superior.\n");
        System.out.println("11. Verifica se é matriz simetrica.\n");
        System.out.println("12. Imprime a correspondente matriz transposta.\n");
        System.out.println("0. Fim.\n");
        System.out.println("Sua opcao: ");

        try {
            escolha = scanner.nextInt();
        } catch(Exception e) {
            escolha = -1;
        }
        return escolha;
    }

    public static void valida(Matriz matriz) { // Passa uma matriz genérica p poder usar o msm código pros dois tipos de matriz
        int escolha, elem, i, j;
        Scanner scanner = new Scanner(System.in);

        do {
            escolha = apresentaMenu();  // Recebe opç escolhida no menú

            switch(escolha) {
                case 0: /* Nao faz nada. */
                    break;
                case 1:
                    System.out.println("Entre com elemento para inserir:");
                    elem = scanner.nextInt();
                    System.out.println("Entre com o indice da linha:");
                    i = scanner.nextInt();
                    System.out.println("Entre com o indice da coluna:");
                    j = scanner.nextInt();
                    matriz.inserir(i, j, elem);
                    break;
                case 2:
                    System.out.println("Entre com o indice da linha do elemento a remover:");
                    i = scanner.nextInt();
                    System.out.println("Entre com o indice da coluna do elemento a remover:");
                    j = scanner.nextInt();
                    matriz.remover(i, j);
                    break;
                case 3:
                    System.out.println("Entre com elemento para buscar:");
                    elem = scanner.nextInt();
                    if(matriz.buscar(elem) == null) {
                        System.out.println("Elemento não encontrado.");
                        break;
                    }
                    i = matriz.buscar(elem)[0];
                    j = matriz.buscar(elem)[1];
                    System.out.println("Elemento encontrado em (" + i + ", " + j + ").");
                    break;
                case 4:
                    System.out.println("Conteudo da matriz:");
                    matriz.imprimir();
                    break;
                case 5:
                    System.out.println("é matriz vazia: " + (matriz.eVazia() ? "sim." : "nao."));
                    break;
                case 6:
                    System.out.println("é matriz diagonal: " + (matriz.eDiagonal() ? "sim." : "nao."));
                    break;
                case 7:
                    System.out.println("é matriz linha: " + (matriz.eLinha() ? "sim." : "nao."));
                    break;
                case 8:
                    System.out.println("é matriz coluna: " + (matriz.eColuna() ? "sim." : "nao."));
                    break;
                case 9:
                    System.out.println("é matriz triangular inferior: " + (matriz.eTriangInf() ? "sim." : "nao."));
                    break;
                case 10:
                    System.out.println("é matriz triangular superior: " + (matriz.eTriangSup() ? "sim." : "nao."));
                    break;
                case 11:
                    System.out.println("é matriz simetrica: " + (matriz.eSimetrica() ? "sim." : "nao."));
                    break;
                case 12:
                    System.out.println("Correspondente matriz transposta:");
                    matriz.imprimeTransposta();
                    break;
            }

        }while(escolha != 0);

        scanner.close();
    }
}
