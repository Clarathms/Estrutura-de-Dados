package com.company;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pilha pilha = new Pilha(10);

        System.out.println("Vetor de 10 posições, mas com duas plhas ao mesmo tempo: Uma indo de baixo para cima e a outra de cima para baixo utilizando LIFO:");
        for (int i = 0; i < pilha.tamanho();i++){    // Adicionando valores da pilha
            pilha.push(i);      // Execução da pilha 1 subindo da posição 0 (add)
            pilha.push2(i);     // Execução da pilha 2 descendo da posição 9 (add e depois remove devido à regra LIFO)

            if (pilha.Estouro()){  // Faz com que a pilha nao estoure, apos as duas serem executadas e para o loop quando as duas se encontram (sem que uma coma o valor da outra)
                break;
            }
        }

        System.out.println(pilha.toString());

        if (pilha.Estouro()){
            System.out.println("Pilha não estourou!");
        }
        else
            System.out.println("Pilha estourou");
    }
}
