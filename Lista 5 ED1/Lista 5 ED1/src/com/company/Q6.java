package com.company;

public class Q6 {
    public static void main(){

        //Complexidade da questão é O(n)

        LDE_Q6 lista = new LDE_Q6();

        System.out.println("Lista de espera de chamada: (Ordem que entraram) ");
        lista.insere("\nPessoa 1",20); //custo da chamada
        lista.insere("Pessoa 2",50);
        lista.insere("Pessoa 3",70);
        lista.insere("Pessoa 4",50);
        lista.insere("Pessoa 5",90);
        lista.imprime();

        System.out.println("Chegam mais chamadas: ");
        lista.insere("Pessoa 6",150);
        lista.insere("Pessoa 7",10);
        lista.insere("Pessoa 8",45);
        lista.imprime();
    }
}
