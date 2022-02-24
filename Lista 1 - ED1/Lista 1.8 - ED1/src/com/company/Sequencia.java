package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Sequencia {
    Scanner scan = new Scanner(System.in);
    Stack <Integer> stack = new <Integer> Stack();

    private int N;

    public void LeDados (){
        System.out.println("Qual será o tamanho N da sequência?");
         N = scan.nextInt();

        System.out.printf("Os pares da sequencia de %d elementos serao: " , N);
        FazConta();

    }

    public void FazConta(){

        for (int i =1; i <= N;i++){
            stack.push(i);      //Adiciona todos os valores
        }

        int valor;
        for (int i =1; i <= N;i++){
            //(1,
            valor = stack.pop();        // Retira o elemento para imprimir
            System.out.printf("(%d , ",valor);
            // 2)
            valor = stack.pop();
            System.out.printf("%d)  ",valor);

            stack.push(valor);
            if (valor ==1){
                break;
            }
        }
    }
}
