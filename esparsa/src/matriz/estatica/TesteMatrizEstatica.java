package matriz.estatica;

import matriz.TesteMatriz;

public class TesteMatrizEstatica {
    public static void main(String[] args) {
        MatrizEstatica matrizEstatica = new MatrizEstatica(new int[][]{{1,0,1},{0,1,0},{1,1,1}});   // Teste com 3 linhas prontas
       TesteMatriz.valida(matrizEstatica);
    }
}
