package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = 1;
        do{
            System.out.println("\nDigite o número da questão desejada:");
            System.out.println("2 - Questão 2");
            System.out.println("3 - Questão 3");
            System.out.println("4 - Questão 4");
            System.out.println("5 - Questão 5");
            System.out.println("6 - Questão 6");
            System.out.println("7 - Questão 7");
            System.out.println("0 - Sair");
            x = scan.nextInt();

            switch (x){
                case 2:
                    // Questão 2
                    Q2 q2 = new Q2 ();
                    System.out.println("Questão 2:");
                    Q2.main();
                    break;
                case 3:
                    //Questão 3
                    Q3 q3 = new Q3();
                    System.out.println("\n\nQuestão 3:");
                    Q3.main();
                    break;
                case 4:
                    // Questão 4
                    Q4 q4 = new Q4();
                    System.out.println("\n\nQuestão 4:");
                    q4.input();
                    break;
                case 5:
                    // Questão 5
                    Q5 q5 = new Q5();
                    System.out.println("\n\nQuestão 5:");
                    q5.input();
                    break;
                case 6:
                    //Questão 6
                    Q6 q6 = new Q6();
                    System.out.println(q6.criaDiretorio());
                    break;
                case 7:
                    //Questão 7
                    Q7 q7 = new Q7();
                    q7.jogo();
                    break;
                default:
            }
        } while (x != 0);
    }
}
