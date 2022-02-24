package matriz.encadeada;
import listaSingular.ListaOrdenada;
import matriz.TesteMatriz;

public class TesteMatrizEncadeada {
    public static void main(String[] args) {

        MatrizEncadeada matrizEncadeada = new MatrizEncadeada(new int[][]{{1,0,1},{0,1,0},{1,1,1}});
        /*
        ListaOrdenada lista = new ListaOrdenada();
        lista.insere(0,1);
        lista.insere(1,0);
        lista.insere(2,1);
*/
      TesteMatriz.valida(matrizEncadeada);
    }
}
