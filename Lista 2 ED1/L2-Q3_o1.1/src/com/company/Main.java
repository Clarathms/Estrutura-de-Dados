package com.company;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //************* Fila de pilhas *******************

        // Fila de pilhas -> Duas pilhas : Uma vira o inverso da outra, formando uma fila
        // Objetivo : Fila [[pilha 1] , [pilha2]]]   -> Inverter ordem da pilha

        int nr;
        Stack <Integer> p1 = new Stack <Integer>();
        Stack <Integer> p2 = new Stack <Integer>();

        p1.push(10);
        p1.push(20);
        p1.push(30);

        p2.push(40);
        p2.push(50);
        p2.push(60);


        Queue<Stack<Integer>> filaDePilhas = new LinkedList<>();    // Cria a fila com as pilhas
        filaDePilhas.add(p1);
        filaDePilhas.add(p2);

        System.out.println("Fila de pilhas: " + filaDePilhas);

//************ Pilha de filas ************************

        Queue<Integer> f1 = new LinkedList<>();
        Queue<Integer> f2 = new LinkedList<>();

        f1.add(1);
        f1.add(2);
        f1.add(3);
        f1.add(4);
        f1.add(5);

        f2.add(6);
        f2.add(7);
        f2.add(8);
        f2.add(9);
        f2.add(10);

        Stack<Queue<Integer>> PilhaDeFilas = new Stack<>();

        PilhaDeFilas.push(f1);
        PilhaDeFilas.push(f2);

      //  PilhaDeFilas.toString();
        System.out.println("\nPilha de filas: " + PilhaDeFilas);

    //**************** Fila de filas *******************

        Queue<Integer> fila1 = new LinkedList<>();
        Queue<Integer> fila2 = new LinkedList<>();

        fila1.add(100);
        fila1.add(110);
        fila1.add(120);
        fila1.add(130);
        fila1.add(140);


        fila2.add(200);
        fila2.add(210);
        fila2.add(220);
        fila2.add(230);
        fila2.add(240);

        Queue<Queue<Integer>> FilaDeFilas;
        FilaDeFilas = new LinkedList<>();
        FilaDeFilas.add(fila1);
        FilaDeFilas.add(fila2);

        System.out.println("\nFila de filas: " + FilaDeFilas);
    }
}

