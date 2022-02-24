package com.company;
import java.util.Stack;
import java.util.Scanner;
public class PF {

    Stack <Character> stack = new <Character> Stack();  //Pilha com os sinais (+,-,*,/)
    Stack <Integer> p2 = new <Integer> Stack();     // Pilha com os valores já divididos
    Scanner scan = new Scanner(System.in);


    private String conta;       // Armazena a conta inteira como String para dividir depois
    private int v1;
    private int v2;
    private int total;
    private char sinal;

//Construtor
    public PF() {
        this.conta = new String();
        this.v1 = v1;
        this.v2 = v2;
        this.total = total;
        this.sinal = sinal;
    }

    public void leExpr(){
        System.out.println("Expressao:");
        conta = scan.nextLine();
        conta = conta.replaceAll("\\s+",""); // Para nao contar os espaços
    }

    public void Parenteses(){   //Inicia a conta a partir dos parenteses
        /*
       int i;
        do{

        } while ( i: conta.toCharArray());*/

        for (char p : conta.toCharArray()){  //Coloca na pilha
            if(p == '('){
                continue; //Inicio de uma expressão
            }
            else if (p == ')'){ // Fecha expressão -> Inicio dos calculos

                //Armazena var
                this.v1 = p2.pop();
                this.v2 = p2.pop();
                this.sinal = stack.pop();

                //Fazer a conta:

                this.total = AplicaSinal(sinal,v1,v2);
                p2.push(total);     //Armazena na pilha o total da conta
            }
            else{
                if(eOperador(p)){
                    stack.push(p);
                }
                else
                    p2.push(Character.getNumericValue(p));

            }
        }
    }

    public int AplicaSinal(char sinal, int v1, int v2){

        int a = 0;
        if(sinal == '*'){
           a = v1*v2;
        }
        else if(sinal=='/'){
            a = v1/v2;
        }
        else if(sinal=='+'){
            a = v1+v2;
        }
        else if(sinal=='-'){
            a = v1-v2;
        }
        else{
            throw new IllegalArgumentException("Sinal inserido incorretamente");        // Aviso
        }
        return a;
    }

    private boolean eOperador(char simbolo) {
        return simbolo == '*' || simbolo == '+' || simbolo == '-' || simbolo == '/';
    }



    public void Total(){
        System.out.println(" Total: " + p2.pop());

    }


}
