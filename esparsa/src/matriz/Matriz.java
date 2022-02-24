package matriz;
public abstract class Matriz {

    protected int m;    // Largura
    protected int n;    // Altura

    public boolean eVazia() {
        return (m == 0 || n == 0);
    }

    public boolean eLinha() {
        return (m==1 && n>0);
    }

    public boolean eColuna() {
        return (m>0 && n==1);
    }

    public boolean eQuadrada() {
        return(m == n);
    }

    public boolean eDiagonal() {
        return (this.eTriangSup() && this.eTriangInf());
    }   // Até aqui usam os mesmos metodos

    public abstract boolean eTriangInf();

    public abstract boolean eTriangSup();

    public abstract boolean eSimetrica();

    public abstract void inserir(int i, int j, int val);

    public abstract void remover(int i, int j);

    public abstract int[] buscar(int el);

    public abstract void imprimir();

    public abstract void imprimeTransposta();
}
