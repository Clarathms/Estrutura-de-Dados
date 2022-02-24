package matriz.encadeada;

import listaSingular.ListaOrdenada;
import matriz.Matriz;

public class MatrizEncadeada extends Matriz {

    private ListaOrdenada[] matriz;

    public MatrizEncadeada() {
        this.matriz = new ListaOrdenada[0];
        this.m = this.n = 0;
    }

    public MatrizEncadeada(int n) { // configura matriz quadrada
        this.matriz = new ListaOrdenada[n];
        for(int i=0; i<n; i++) { matriz[i] = new ListaOrdenada(); }
        this.m = this.n = n;                                        // Com a lista vazia -> Todos os elem são 0
    }

    public MatrizEncadeada(int m, int n) {  // Caso seja mxn
        this.matriz = new ListaOrdenada[m];
        for(int i=0; i<m; i++) { matriz[i] = new ListaOrdenada(); }
        this.m = m;
        this.n = n;
    }

    public MatrizEncadeada(ListaOrdenada[] matriz, int largura) {   // Já tenho a lista ordenada e tranformo em matriz
        this.matriz = matriz;
        this.m = matriz.length; // Define qtd de linhas
        this.n = largura;   // Qtd elem em cada linha
    }

    public MatrizEncadeada(int[][] matriz) {
        this.setMatriz(matriz);
    }   // estática  -> encadeada

    /* A matriz 1 é alterada e passa a ter o mesmo valor que o resultado */
    public static MatrizEncadeada somar(MatrizEncadeada matriz1, MatrizEncadeada matriz2) {
        if(matriz1.m != matriz2.m || matriz1.n != matriz2.n) return null;   // Verif se são do msm tam
        ListaOrdenada[] resultado = new ListaOrdenada[matriz1.m];
        for(int i=0; i<matriz1.m; i++) {
            resultado[i] = ListaOrdenada.soma(matriz1.matriz[i], matriz2.matriz[i]);    // Percorre cada lista e soma as linhas das mats
        }
        return new MatrizEncadeada(resultado, matriz1.n);   //Descubro o tamanho da lista
    }

    public static MatrizEncadeada multiplicar(MatrizEncadeada matriz1, MatrizEncadeada matriz2) {
        if(matriz1.n != matriz2.m) return null; // Ver se largura da m1 é diferente do comprimento da m2
        ListaOrdenada[] resultado = new ListaOrdenada[matriz1.m];
        for(int i=0; i<matriz1.m; i++) {
            for(int j=0; j<matriz2.n; j++) {
                if( resultado[i] == null)  resultado[i] = new ListaOrdenada();  // Se for nulo cria matriz vazia
                resultado[i].insere(j, obterElMultiplic(matriz1.matriz, matriz2.matriz, i, j));
            }
        }
        return new MatrizEncadeada(resultado, matriz2.n);
    }

    private static int obterElMultiplic(ListaOrdenada[] matriz1, ListaOrdenada[] matriz2, int i, int j) {
        int resultado = 0;
        for (int k = 0; k < matriz2.length; k++) {
            resultado += matriz1[i].getVal(k) *matriz2[k].getVal(j);        // getval pega valores das colunas
        }
        return resultado;
    }

    /* funcao que configura a matriz encadeada a partir de uma matriz estatica */
    public void setMatriz(int[][] matriz) {
        m = matriz.length;
        n = m > 0 ? matriz[0].length : m;
        this.matriz = new ListaOrdenada[m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matriz[i][j] != 0) {
                    if(this.matriz[i] == null) this.matriz[i] = new ListaOrdenada();
                    this.matriz[i].insere(j, matriz[i][j]);
                }
            }
        }
    }

    public void inserir(int i, int j, int val) {
        if(i >= m || j >= n || val == 0) return;
        matriz[i].insere(j, val);
    }

    public void remover(int i, int j) {
        if(i >= m || j >= n) return;
        matriz[i].remove(j);    // Percorre todos os elem até chegar na posição
    }

    public int[] buscar(int el) {

        for(int i=0; i<m; i++) {

            if(el != 0) {   // Deixa mais rápido se pula os 0
                int j = matriz[i].busca(el);
                if(j != -1) return new int[]{i, j};
            } else {
                for(int j=0; j<n; j++) {
                    if(matriz[i].getVal(j) == 0) return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public void imprimir() {
        System.out.println();
        if(this.eVazia()) {
            System.out.println("| |");
            return;
        }
        for(int i=0; i<m; i++) {
            System.out.print("| ");
            for (int j=0; j<n; j++) {
                System.out.print(matriz[i].getVal(j) + " ");
            }
            System.out.println("|");
        }
    }

    public MatrizEncadeada transposta() {   // Troca linha por coluna
        ListaOrdenada[] resultado = new ListaOrdenada[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(resultado[j] == null) resultado[j] = new ListaOrdenada();
                resultado[j].insere(i, matriz[i].getVal(j));
            }
        }
        return new MatrizEncadeada(resultado, m);
    }

    public void imprimeTransposta() {
        transposta().imprimir();
    }

    public boolean eTriangInf() {   // Melhor que na Estática pq é só ver se não tem elem nessa metade (já vão ser 0)
        if(!this.eQuadrada()) return false;
        for(int i=0; i<m; i++) {
            if(!matriz[i].eTriangInf(i)) return false;
        }
        return true;
    }

    public boolean eTriangSup() {       // Verif o primeiro elem que não é 0, checa a posição
        if(!this.eQuadrada()) return false;
        for(int i=0; i<m; i++) {
            if(!matriz[i].eTriangSup(i)) return false;
        }
        return true;
    }

    public boolean eSimetrica() {
        if(!this.eQuadrada()) return false;
        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {
                if(matriz[i].getVal(j) != matriz[j].getVal(i)) return false;
            }
        }
        return true;
    }
}
