package com.company;

public class Fila
{
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public Fila(int tam)
    {
        tamanho = tam;
        vetor = new int[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia()
    {
        return (n == 0);
    }

    public boolean cheia()
    {
        return (n == tamanho);
    }

    //Retiramos o elemento do in�cio da fila
    public int remove()
    {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia())
        {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    public boolean insere(int elemento)
    {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        }
        else
            return false;
    }

    public void combinaFilas(Fila f1, Fila f2) {

        Fila F = new Fila(f1.tamanho + f2.tamanho);

        while(!f1.vazia() || !f2.vazia()) {
            if (F.cheia()) {
                System.out.println("a fila ja esta cheia!!!");
                break;
            }
            if(!f1.vazia()){
                F.insere(f1.remove());
            }
            if(!f2.vazia()){
                F.insere(f2.remove());
            }
        }

        //imprime
        int i;
        if (F.vazia()) {
            System.out.println("Fila está vazia.");
        } else {
            System.out.print("Fila Mista: ");
            for( i = F.ini; i < F.n; i++){
                if(i == F.n-1){
                    System.out.print(F.vetor[i]);
                }else{
                    System.out.print(F.vetor[i]+", ");
                }
            }
        }
    }





}