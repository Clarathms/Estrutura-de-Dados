package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    //constantes
    //usar na hora da verificação
    final static String ABRE = "({[";
    final static String FECHA =")}]";

    public static void main(String[] args) {
        System.out.println("Insira a expressão: ");
        Scanner scanner = new Scanner(System.in);
        String sequencia = scanner.nextLine();

        System.out.println(checkSimbolosBalanceados(sequencia));

    }

    public static boolean checkSimbolosBalanceados(String sequencia){

        boolean balanceado = true;
        Stack<Character> stack = new Stack<>(); //classe wraps

        char simbolo, topo;
        int i = 0;
        while (i < sequencia.length() && balanceado){
            simbolo = sequencia.charAt(i);

            if (ABRE.indexOf(simbolo) > - 1){   //push dos simbolos ({[
                stack.push(simbolo);
            }else if (FECHA.indexOf(simbolo) > - 1){
                //stack desbalanceada
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    topo = stack.pop();

                    //agr falta comp se os simb são ==
                    if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)){
                        System.out.println("Não está Balanceanda");
                        return false;
                    }else{
                        System.out.println("Balanceada");
                        return true;
                    }
                }
            }
            i++;
        }
        return false;
    }
}