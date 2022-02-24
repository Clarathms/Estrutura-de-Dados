package listaSingular;

public class ListaOrdenada  extends Lista {

    /* Pega o valor do elemento, dado a coluna */
    public int getVal(int coluna) {
        for(Elo p=prim; p!=null; p=p.prox) {
            if(p.coluna == coluna) return p.val;
            if(p.coluna > coluna) return 0;
        }
        return 0;
    }

    /* Verifica se a lista da linha i satisfaz a linha de uma matriz triangular inferior */
    public boolean eTriangInf(int i) {
        for( Elo p=prim; p!=null; p=p.prox) {
            if( i<p.coluna && p.val!=0) return false;
        }
        return true;
    }

    /* Verifica se a lista da linha i satisfaz a linha de uma matriz triangular superior */
    public boolean eTriangSup(int i) {
        for( Elo p=prim; p!=null; p=p.prox) {
            if( p.coluna<i && p.val!=0) return false;
            if(p.coluna >= i) break;
        }
        return true;
    }

    public void insere(int coluna, int val) {
        if(val==0){
            this.remove(coluna);
            return;
        }

        Elo p, q = new Elo(coluna, val);
        Elo ant = null;

        for (p = prim; ((p != null) && (p.coluna < coluna)); p = p.prox)
            ant = p;

        if(p != null && p.coluna == coluna) {
            p.val = val;
            q = null;
        } else {
            if (ant == null)
                prim = q;
            else
                ant.prox = q;
            q.prox = p;
        }
    }

    public void incrementa(int coluna, int val) {
        if(val==0){ return; }

        Elo p, q = new Elo(coluna, val);
        Elo ant = null;

        for (p = prim; ((p != null) && (p.coluna < coluna)); p = p.prox)
            ant = p;

        if(p != null && p.coluna == coluna) {
            p.val += val;
            q = null;
        } else {
            if (ant == null)
                prim = q;
            else
                ant.prox = q;
            q.prox = p;
        }
    }

    /* Remove da lista o elemento com coluna igual ao valor do argumento". Ret. true se removeu. */
    public boolean remove(int coluna) {
        Elo p;
        Elo ant = null; /* referencia para anterior */

        for(p = prim; ((p != null) && (p.coluna < coluna)); p = p.prox)
            ant = p;

        /* Se p e null ou p.dado != elem, entao nao encontrou elemento. */
        if ((p == null) || (p.coluna != coluna))
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

    /* soma duas listas e retorna o resultado (Atenção: altera o valor da lista l1) */
    public static ListaOrdenada soma(ListaOrdenada l1, ListaOrdenada l2) {
        for(Elo p=l2.prim; p!=null; p=p.prox) {
            l1.incrementa(p.coluna, p.val);
        }
        return l1;
    }
}
