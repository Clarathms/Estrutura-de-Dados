package com.company;

import java.util.Scanner;

public class Processo extends SistemaOperacional { // Lista e imprime o menu dos processos possíveis, que serão executados na classe SistemaOperacional


    public Processo(int tam) {
        super(tam);
    }

    public void imprime()
    {
        int i, j;

        if (vazia())
            System.out.println("Fila de processos esta vazia.");
        else
            for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
                System.out.println(j + "-" + vetor[i]); // O identificador é o j
    }

    public int menu()
    {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        System.out.println("Menú");
        System.out.println("-----------------------------------------------------");
        System.out.println("Selecione a opcao:");
        System.out.println("1. Adicionar processo novo na fila de processos.");
        System.out.println("2. Remover processo da fila."); // Automaticamente pega o que estava a mais tempo (primeiro da fila)
        System.out.println("3. Imprimir elementos da fila de processos.");
        System.out.println("0. Fim.");
        System.out.println("-----------------------------------------------------");
        System.out.print("Opcao escolhida: ");
        escolha = scanner.nextInt();

        return escolha;
    }
}
