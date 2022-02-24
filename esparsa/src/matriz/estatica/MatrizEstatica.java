package matriz.estatica;

import matriz.Matriz;

public class MatrizEstatica extends Matriz {

    private int[][] matriz; //cria matriz

    public MatrizEstatica() {
        this.matriz = new int[0][0];
        this.m = this.n = 0;
    }

    public MatrizEstatica(int n) {
        this.matriz = new int[n][n];    // Configurar tamanho n
        this.m = this.n = n;
    }

    public MatrizEstatica(int m, int n) {
        this.matriz = new int[m][n];
        this.m = m;
        this.n = n;
    }

    public MatrizEstatica(int[][] matriz) {
        this.setMatriz(matriz);
    }       // Usado pra testes + somar...

    public static MatrizEstatica somar(MatrizEstatica matriz1, MatrizEstatica matriz2) {
        if(matriz1.m!=matriz2.m || matriz1.n!=matriz2.n) return null;   // Checa se tem os mesmos tamanhos
        int[][] resultado = new int[matriz1.m][matriz1.n];
        for(int i=0; i<matriz1.m; i++) {    // Soma das matrizes
            for(int j=0; j<matriz1.n; j++) {
                resultado[i][j] = matriz1.matriz[i][j] + matriz2.matriz[i][j];
            }
        }
        return new MatrizEstatica(resultado);
    }

    public static MatrizEstatica multiplicar(MatrizEstatica matriz1, MatrizEstatica matriz2) {
        if(matriz1.n != matriz2.m) return null; // checa se a coluna da m1 é nr de linhas da m2
        int[][] resultado = new int[matriz1.m][matriz2.n];  // Matriz que recebe resultado
        for(int i=0; i<matriz1.m; i++) {
            for(int j=0; j<matriz2.n; j++) {
                resultado[i][j] = obterElMultiplic(matriz1.matriz, matriz2.matriz, i, j);   // Chama metodo que Multiplica matrizes
            }
        }
        return new MatrizEstatica(resultado);
    }

    private static int obterElMultiplic(int[][] matriz1, int[][] matriz2, int i, int j) {       // Multiuplica linhas e colunas das matrizes
        int resultado = 0;
        for (int k=0; k < matriz2.length; k++) {
            resultado += matriz1[i][k]*matriz2[k][j];
        }
        return resultado;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
        m = matriz.length;
        n = m>0 ? matriz[0].length : m;
    }

    public void inserir(int i, int j, int val) {
        if(i>=m || j>=n) return;    // Checa se i e j são menores que largura e comprimento
        matriz[i][j] = val;
    }

    public void remover(int i, int j) {
        if(i>=m || j>=n) return;
        matriz[i][j] = 0;
    }

    public int[] buscar(int el) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(el == matriz[i][j]) {
                    return new int[]{i, j}; // Se tiver, retorna posição
                }
            }
        }
        return null;    // Se não tiver
    }

    public void imprimir() {
        System.out.println();
        if(this.eVazia()) { // Checa se é vazia
            System.out.println("| |");
            return;
        }
        for(int i=0; i<m; i++) {
            System.out.print("| ");
            for(int j=0; j<n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public MatrizEstatica transposta() {
        int[][] resultado = new int[n][m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                resultado[j][i] = matriz[i][j]; // Troca a posição das linhas por colunas
            }
        }
        return new MatrizEstatica(resultado);
    }

    public void imprimeTransposta() {
        transposta().imprimir();
    }

    public boolean eTriangInf() {
        if(!this.eQuadrada()) return false; // Para ser triangular tem que ser quadrada
        for(int i=0; i<m; i++) {
            for(int j=i+1; j<n; j++) {  // Percorre só a metade acima da diagonal principal
                if(matriz[i][j] != 0) return false; //Todos devem ser 0 para que seja considerada
            }
        }
        return true;
    }

    public boolean eTriangSup() {
        if(!this.eQuadrada()) return false;
        for(int j=0; j<n; j++) {
            for(int i=j+1; i<m; i++) {  // Percorre de baixo até a metade
                if(matriz[i][j] != 0) return false;
            }
        }
        return true;
    }

    public boolean eSimetrica() {
        if(!this.eQuadrada()) return false;
        for(int j=0; j<n; j++) {
            for(int i=j+1; i<m; i++) {
                if(matriz[i][j] != matriz[j][i]) return false;
            }
        }
        return true;
    }
}
