package listaSingular;

public class Lista {

    /* Referancia para primeiro elemento */
    protected Elo prim;

    protected static class Elo {

        protected int coluna;
        protected int val;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(int coluna, int val) {
            this.coluna = coluna;
            this.val = val;
            prox = null;
        }

        public Elo(int coluna, int val, Elo prox) {
            this.coluna = coluna;
            this.val = val;
            this.prox = prox;
        }
    }

    public Lista() {
        prim = null;
    }

    /* Testa se a lista esta vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Verifica se um determinado valor esta na lista. */
    /* Se estiver, retorna o valor da coluna do elemento, se não, retorna -1 */
    public int busca(int val) {
        for(Elo p=prim; p!=null; p=p.prox) {
            if(p.val == val)
                return p.coluna;
        }
        return -1;
    }

    /* Remove da lista o primeiro elemento com valor igual a val". Ret. true se removeu. */
    public boolean remove(int val) {
        Elo p;
        Elo ant = null; /* Referencia para anterior. */

        for(p = prim; ((p != null) && (p.val != val)); p = p.prox)
            ant = p;

        /* Se p e null, entao nao encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do inicio. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        /* Remove a ultima referencia para o elo a ser removido. Dessa forma,
         * o Garbage Collector ira liberar essa memoria. */
        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;
        for(p=prim; p!=null; p=p.prox) {
            System.out.print(p.val + " ");
        }
    }

    /* Calcula e retorna o tamanho da lista. */
    public int tamanho() {
        int tam = 0;
        for(Elo p=prim; p!=null; p=p.prox) {
            tam++;
        }
        return tam;
    }

    public int max() {
        if(this.vazia()) return 0;

        Elo p;
        int maior = Integer.MIN_VALUE;

        for(p=prim; p!=null; p=p.prox) {
            if(maior < p.val)
                maior = p.val;
        }
        return maior;
    }
}
