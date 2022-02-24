package com.company;

public class Pilha {
    private int n;
    private int vetor[];
    private int topo;

    //Construtor
    public Pilha(int tamanho_vetor) {
        n = tamanho_vetor;
        vetor = new int[tamanho_vetor];
        topo = -1;
    }

    //Checar se está vazia ou cheia
    public boolean vazia() {return topo == -1;}
    public boolean cheia() {return topo == n - 1;}

    //Retirar elemento da pilha
    public int pop() {
        int c = '\0';
        if (!this.vazia()) {
            c = vetor[topo];
            topo--;
        }
        else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop n�o funcionou.");
        }
        return c;
    }

    //Inserir
    public void push(int elemento) {
        if (!this.cheia()) {
            vetor[++topo] = elemento;
        }
        else {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push nao funcionou.\n");
        }
    }

    // Contagem de pares na sequência
    public void Pares(int n) {

        int contagem = 0;
        for (int i = 1; i <= n; i++){
            if ((i % 2) == 0) {
                contagem++;
            }
            push(i);
        }

        System.out.println("Número de pares formados na sequencia: " + contagem);
    }
}
