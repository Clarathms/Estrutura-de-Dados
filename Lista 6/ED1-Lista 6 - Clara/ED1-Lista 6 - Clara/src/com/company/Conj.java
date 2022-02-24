package com.company;

public class Conj {

    private Elo prim;  /* Refer�ncia para primeiro elemento. */

    /* Classe auxiliar para guardar cada elemento do conjunto. */
    private class Elo{

        int dado;
        Elo prox;
        Elo ant;  // add elemento ao conjunto para referenciar elem anterior (Q1)

        public Elo(){
            prox = null;
            this.ant = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo prox_elem){
            dado = elem;
            prox = prox_elem;
        }
    }

    public Conj(){
        prim = null;
    }

    /* Fun��o privada para realizar uma c�pia de um outro conjunto. */
    private void copia(Conj cj2){
        Elo ult = null, q;

        prim = null;
        for (Elo p = cj2.prim; p != null; p = p.prox)
        {
            q = new Elo(p.dado);
            if (ult == null)
                prim = q;
            else
                ult.prox = q;
            ult = q;
        }
    }

    /* Fun��o privada para realizar uma c�pia de um outro conjunto. */
    public void apaga(){
        for (Elo p = prim; p != null; p = prim){
            prim = prim.prox;
            p.prox = null;
        }
    }

    /* Simula uma sobrecarga do operador de atribui��o. */
    public Conj atribui(Conj cj2){
        if (this != cj2)
        {
            apaga();
            copia(cj2);
        }

        return this;
    }

    /* Testa se o conjunto est� vazio. */
    public boolean vazio(){
        return prim == null;
    }

    /* Teste de pertin�ncia. Usa fato de estar ordenado */
    public boolean pertence(int valor){
        Elo p;

        for (p = prim; ((p != null) && (p.dado < valor)); p = p.prox);

        if ((p == null) || (p.dado > valor)) return false;

        return true;
    }

    /* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
       Retorna false se elemento j� estava l�. */
    public boolean insere(int valor){
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado == valor) return false;
            if (p.dado > valor) break;
            ant = p;

           /* if (p.prox == null){  // Q1
                this.maior = p.dado;
            }*/
        }
        Elo q = new Elo(valor);
        if (p == prim)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;

       this.prim.ant = p; // Recebe ultimo elemento -Maior

        return true;
    }

    /* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
       Retorna false se elemento n�o estava l�. */
    public boolean remove(int valor){
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado > valor) return false;
            if (p.dado == valor) break;
            ant = p;
        }
        if (p == null) return false;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;
        return true;
    }

    /* M�todo para uni�o de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a uni�o.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Conj uniao(Conj cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        Conj uniao = new Conj();
        while ( (p1 != null) || (p2 != null) )
        {
            if ( (p1 != null) && ( (p2 == null) || (p1.dado < p2.dado)))
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;
            }
            else
            {
                q = new Elo(p2.dado);
                if ((p1 != null) && (p1.dado == p2.dado))
                    p1 = p1.prox;
                p2 = p2.prox;
            }

            if (ult == null)
                uniao.prim = q;
            else
                ult.prox = q;

            ult = q;
        }

        return uniao;
    }

    /* M�todo para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Conj intersecao(Conj cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        Conj inter = new Conj();

        while ( (p1 != null) && (p2 != null) )
        {
            if (p1.dado < p2.dado)
            {
                p1 = p1.prox;
            }
            else if(p2.dado < p1.dado)
            {
                p2 = p2.prox;
            }
            else
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;
                p2 = p2.prox;

                if (ult == null)
                    inter.prim = q;
                else
                    ult.prox = q;

                ult = q;
            }
        }

        return inter;
    }

    /* Retorna cardinalidade do conjunto */
    public int tamanho() {
        int tam = 0;
        Elo p;

        for(p = prim; p != null; p = p.prox)
            tam++;
        return tam;
    }

    /* Imprime todos os elementos do conjunto */
    public void imprime() {
        Elo p;
        for(p = prim; p != null; p = p.prox)
            System.out.print(p.dado + " ");
        System.out.println();
    }

    //********************* QUESTAO 1 **************************************

    //Como o conjunto será naturalmente ordenado do menor para o maior, pega o primeiro valor, que sempre será o menor
    public int menor() {
        if (prim == null) {
            return 0;
        }
        System.out.println(prim.dado);
        return prim.dado;
    }

    public int maior () {
        if (prim == null) {
            return 0;
        }
        System.out.println(this.prim.ant.dado);  // Recebe ultimo elemento
        return prim.ant.dado;
    }
//*******************************************************************************





}
