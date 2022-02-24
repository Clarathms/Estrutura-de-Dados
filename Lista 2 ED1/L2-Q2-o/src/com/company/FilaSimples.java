package com.company;

import java.util.Scanner;

public class FilaSimples extends Fila
{
    public FilaSimples(int tam)
    {
        super(tam);
    }

    public void imprime()
    {
        int i, j;

        if (vazia())
            System.out.println("Fila est� vazia.");
        else
            for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
                System.out.println(j + " " + vetor[i]);
    }

    public int menu()
    {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("------------------ Menu ------------------");
        System.out.println("Selecione a opcao:\n");
        System.out.println("1. Insere elemento na fila 1.");
        System.out.println("2. Remove elemento da fila 1.");
        System.out.println("4. Insere elemento na fila 2.");
        System.out.println("5. Remove elemento da fila 2.");
        System.out.println("7. Imprime elementos da fila Mista.");
        System.out.println("0. Fim.");
        System.out.println("---------------------------------------");

        System.out.print("Opcao: ");
        escolha = scanner.nextInt();

        return escolha;
    }
}