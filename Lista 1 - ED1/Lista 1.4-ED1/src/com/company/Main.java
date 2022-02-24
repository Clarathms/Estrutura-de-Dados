package com.company;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       Stack<Object> stack = new Stack<>();
       PilhaFilha<Object> pilha = new PilhaFilha<Object>(10);

       for (int i =0; i<8;i++){
           pilha.push(i);
       }

        Object objeto1 = 100;
        Object objeto2 = 200;

        pilha.Obj(objeto1);
        pilha.Obj(objeto2);
        System.out.println("Foram inseridos dois valores objeto na pilha:(100 e 200)");
        System.out.println(pilha.toString());

        // Falso - obj1 != obj2
        System.out.println("\nVerificar se obj1 e obj2 são iguais utilizando a classe equals:");
        System.out.println("False - Não são iguais // True : São iguais\n");
        System.out.println(pilha.toString());
        System.out.println(Objects.equals(objeto2, objeto1));       // False - não são iguais / True - são valores iguais


        // Verdade - obj1 == obj2
        pilha.pop();
        objeto2 = 100;
        pilha.Obj(objeto2);

        System.out.println(pilha.toString());
        System.out.println(Objects.equals(objeto2, objeto1));

        
    }
}
