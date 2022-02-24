import com.sun.security.jgss.GSSUtil;
import matriz.encadeada.MatrizEncadeada;
import matriz.estatica.MatrizEstatica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorDados {

    public static final String DADOS_DIR_REL = "\\src\\tempos";

    public static void main(String[] args) {
        int[] dims = new int[]{10, 20, 30, 40, 50, 100, 200, 500, 1000, 10000};

        //int[] dims = new int[]{10, 20, 30, 40, 50, 100, 200, 500, 1000, 10000, 20000, 50000, 100000};

        File dir = new File(System.getProperty("user.dir") + DADOS_DIR_REL);
        Dados.deletarArquivos(dir);   // Exclui arquivos txt anteriores

        for(int dim : dims) {
            int[][] matriz = Dados.gerarMatriz(dim);  // Cria matriz generica para as outras usarem como base
            MatrizEstatica matrizEstatica = new MatrizEstatica(matriz);
            MatrizEncadeada matrizEncadeada = new MatrizEncadeada(matriz);
            Dados.escreverDados(matrizEstatica, matrizEncadeada, dim);    // Começa a escrever os dados novos
        }

    }
/*
    public static int[][] gerarMatriz(int N) {  // Recebe tam da matriz
        int[][] matriz = new int[N][N];
        int i, j, contaZeros = 6*N*N/10;    // 60% dos 0
        Random rand = new Random();

        //  matriz com elementos indo de 1 a 10
        for(i=0; i<N; i++) {
            for(j=0; j<N; j++) {
                matriz[i][j] = rand.nextInt(10) + 1;
            }
        }

       //* troca aleatoriamente 60% dos elementos por zero
        while(contaZeros > 0) {
            i = rand.nextInt(N);    // Define valores aleatorios aos elem
            j = rand.nextInt(N);
            if(matriz[i][j]==0) continue;
            matriz[i][j] = 0;   // Escolhe posição aleatoria e atribui 0 a ela
            contaZeros--;
        }
        return matriz;
    }

    // Quando começo a rodar o código, apaga os arquivos txt e cria novos para os valores novos
    public static void deletarArquivos(File dirPath) {
        File[] filesList = dirPath.listFiles();
        if(filesList == null) return;
        for(File file : filesList) {
            if(file.isFile()) {
                file.delete();
            } else {
                deletarArquivos(file);
            }
        }
    }
    // Mostra o tempo de execução de cada matriz e passa p um arquivo de texto, junto da dimensao
    public static void escreverDados(MatrizEstatica estatica, MatrizEncadeada encadeada, int dim) {
        long tempoAntes=0, tempoDepois=0, tempoEstatica=0, tempoEncadeada=0;
        int i, j, val;
        Random rand = new Random();

        // inserir
        i = rand.nextInt(dim);  // val aleat p linha / coluna / valor q quero inserir
        j = rand.nextInt(dim);
        val = rand.nextInt(dim);

        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.inserir(i, j, val);
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {  // Se o valor for mt grande -> Não pega ele
                // Multiplicando por 8 o valor será imenso, logo, se ainda assim entrar no If, será um valor errado, então não pega ele
                tempoEstatica += tempoEstatica/(k+1);
            } else {    // se for = 0
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.inserir(i, j, val);
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                    tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10; // salva os dados e pega a média dos tempos
        tempoEstatica = tempoEstatica/10;

        try {
            // Escreve no arquivo a dimensão da matriz (cada linha é uma dimensão)
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\inserir.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");    // Como será escrito
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // remover
        tempoEstatica = tempoEncadeada = 0;
        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.remover(i, j);
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {
                tempoEstatica += tempoEstatica/(k+1);
            } else {
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.remover(i, j);
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10;
        tempoEstatica = tempoEstatica/10;

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\remover.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buscar
        tempoEstatica = tempoEncadeada = 0;
        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.buscar(val);
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {
                tempoEstatica += tempoEstatica/(k+1);
            } else {
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.buscar(val);
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10;
        tempoEstatica = tempoEstatica/10;

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\buscar.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // eTriangInf
        tempoEstatica = tempoEncadeada = 0;
        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.eTriangInf();
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {
                tempoEstatica += tempoEstatica/(k+1);
            } else {
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.eTriangInf();
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10;
        tempoEstatica = tempoEstatica/10;

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\eTriangInf.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // eTriangSup
        tempoEstatica = tempoEncadeada = 0;
        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.eTriangSup();
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {
                tempoEstatica += tempoEstatica/(k+1);
            } else {
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.eTriangSup();
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10;
        tempoEstatica = tempoEstatica/10;

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\eTriangSup.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // eSimetrica
        tempoEstatica = tempoEncadeada = 0;
        for(int k=0; k<10; k++) {
            tempoAntes = System.nanoTime();
            estatica.eSimetrica();
            tempoDepois = System.nanoTime();
            if(tempoEstatica> 0 && 8*tempoEstatica < (tempoDepois - tempoAntes)) {
                tempoEstatica += tempoEstatica/(k+1);
            } else {
                tempoEstatica += (tempoDepois - tempoAntes);
            }

            tempoAntes = System.nanoTime();
            encadeada.eSimetrica();
            tempoDepois = System.nanoTime();
            if(tempoEncadeada> 0 && 8*tempoEncadeada < (tempoDepois - tempoAntes)) {
                tempoEncadeada += tempoEncadeada/(k+1);
            } else {
                tempoEncadeada += (tempoDepois - tempoAntes);
            }
        }
        tempoEncadeada = tempoEncadeada/10;
        tempoEstatica = tempoEstatica/10;

        try {
            FileWriter file = new FileWriter(System.getProperty("user.dir") + DADOS_DIR_REL + "\\eSimetrica.txt", true);
            file.write(tempoEstatica + "," + tempoEncadeada + "," + dim + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
