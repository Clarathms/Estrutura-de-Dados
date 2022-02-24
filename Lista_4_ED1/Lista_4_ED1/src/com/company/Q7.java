package com.company;

public class Q7 {

    public void jogo() {
        ListaQ7 lista = new ListaQ7();
        Inimigo i1 = new Inimigo(10);  // Quanto tem de vida
        Inimigo i2 = new Inimigo(15);
        Inimigo i3 = new Inimigo(25);

        lista.insere(i1);
        lista.insere(i2);
        lista.insere(i3);

        lista.efetuarDano(i1, 5);
        lista.efetuarDano(i2, 20);
        lista.efetuarDano(i3, 30);

        lista.imprime();
    }

}
