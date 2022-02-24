package com.company;

public class ListaQ7 extends ListaQ4 <Inimigo> {

    public Inimigo localizar(Inimigo inimigo) {
        boolean existeInimigo = super.busca(inimigo);
        if (existeInimigo) return inimigo;
        return null;
    }

    public void efetuarDano(Inimigo inimigo, int dano) {
        if (super.busca(inimigo)) {
            inimigo.setVida(inimigo.getVida() - dano);
            if (inimigo.getVida() <= 0) {
                super.remove(inimigo);      // Remove o inimigo
            }
        }
    }




}
