package com.company;
public class ConjGenerico<T extends Comparable<T>>
{
    private Elo prim;  /* Refer�ncia para primeiro elemento. */

    /* Classe auxiliar para guardar cada elemento do conjunto. */
    private class Elo{
        T dado;
        Elo prox;

        public Elo(){
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo prox_elem){
            dado = elem;
            prox = prox_elem;
        }
    }

    public ConjGenerico(){
        prim = null;
    }

    /* Fun��o privada para realizar uma c�pia de um outro conjunto. */
    private void copia(ConjGenerico<T> cj2){
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
        }
    }

    /* Simula uma sobrecarga do operador de atribui��o. */
    public ConjGenerico<T> atribui(ConjGenerico<T> cj2){
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
    public boolean pertence(T valor){
        Elo p;

        for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

        if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;

        return true;
    }

    /* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
       Retorna false se elemento j� estava l�. */
    public boolean insere(T valor){
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado.compareTo(valor) == 0) return false;
            if (p.dado.compareTo(valor) > 0) break;
            ant = p;
        }
        Elo q = new Elo(valor);
        if (p == prim)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
        return true;
    }

    /* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
       Retorna false se elemento n�o estava l�. */
    public boolean remove(T valor){
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado.compareTo(valor) > 0) return false;
            if (p.dado.compareTo(valor) == 0) break;
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
    public ConjGenerico<T> uniao(ConjGenerico<T> cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        ConjGenerico<T> uniao = new ConjGenerico<T>();

        while ( (p1 != null) || (p2 != null) )
        {
            if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
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
    public ConjGenerico<T> intersecao(ConjGenerico<T> cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        ConjGenerico<T> inter = new ConjGenerico<T>();

        while ( (p1 != null) && (p2 != null) )
        {
            if (p1.dado.compareTo(p2.dado) < 0)
            {
                p1 = p1.prox;
            }
            else if(p2.dado.compareTo(p1.dado) < 0)
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

    /* Exerc�cio de aula: realizar a opera��o de diferen�a entre conjuntos. */
    public ConjGenerico<T> diferenca(ConjGenerico<T> conj2)
    {
        Elo p1 = prim;
        Elo p2 = conj2.prim;
        Elo q, ult = null;

        ConjGenerico<T> dif = new ConjGenerico<T>();

        while (p1 != null)
        {
            if ((p2 == null) || (p1.dado.compareTo(p2.dado) < 0))
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;

                if (ult == null)
                    dif.prim = q;
                else
                    ult.prox = q;

                ult = q;
            }
            else if(p2.dado.compareTo(p1.dado) < 0)
            {
                p2 = p2.prox;
            }
            else
            {
                p1 = p1.prox;
                p2 = p2.prox;
            }
        }

        return dif;
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

    // ********************************* QUESTÃO 2 ****************************************

    public ConjGenerico<T> complementar(ConjGenerico<T> universo) {

        Elo q = null, p1 = this.prim, p2 = universo.prim;
        ConjGenerico<T> complementar = new ConjGenerico<T>();

        do {
            if (p2.dado.compareTo(p1.dado) != 0 )    // Conj é complementar
            {
                //  q = new Elo(p2.dado);   // Variavel recebe o valor que eu quero passar para o conj complementar antes de passar P2 pro proximo valor
                // complementar.prim = q;    // NAO FUNCIONA -> Pega so o ultimo valor
                complementar.insere(p2.dado);   // Armazena valores de acordo com o loop do conj
                p2 = p2.prox;
            }
            else{
                if (p1.prox != null) {  // NAO TIRA ESSE IF
                    p1 = p1.prox;
                    p2 = p2.prox;
                }
                else if (p1.prox == null){
                    p2 = p2.prox;   // Se p1 for nulo, começo a considerar apenas o p2
                }
                else{
                    throw new IllegalArgumentException("O conjunto original nao possui complementar ao conjunto universo");
                }
            }
        } while (p2 != null);

        complementar.imprime();
        exceçao(universo);  // Checa se conj original possui elementos que o universal não possui
        return complementar;
    }


    public void exceçao (ConjGenerico<T> universo){

    /* Se o conjunto original possuir elementos de fora do
    conjunto universo informado o método deve lançar uma exceção.*/
        Elo q = null, p2 = this.prim, p1 = universo.prim;   // Troca p2 e p1
        do {
            if (p2.dado.compareTo(p1.dado) != 0 )  {   // Conj original possui um elemento que o universal não possui
                throw new IllegalArgumentException("O conjunto original possui elementos de fora do conjunto Universo");
            }
            else{
                if (p1.prox != null) {  // NAO TIRA ESSE IF
                    p1 = p1.prox;
                    p2 = p2.prox;
                }
                else{
                    p2 = p2.prox;
                }
            }
        } while (p2 != null);
    }
//********************************************************************************************

//*********************************** QUESTAO 3 *****************************************

    public boolean subconjunto(ConjGenerico<T> conj2){
        //return this.intersecao(conj2) == this ? true : false;
        Elo p1 = this.prim, p2 = conj2.prim;

        // Checar se P1 está dentro de C2 -> Se é subconjunto

        while ( (p1 != null) && (p2 != null) )  {
            if (p1.dado.compareTo(p2.dado) != 0 )  {    //Não é subconjunto
                p2 = p2.prox;   // Passa para o proximo valor (Pois depois podem surgir valores iguais -> Por isso Não pula fora do loop agora
            }
            else if (p1.prox != null) {  // NAO TIRA ESSE IF
                    p1 = p1.prox;   // Passa valores
                    p2 = p2.prox;
                }
            else{
                System.out.println("É subconjunto");
                return true;
            }
        }
        System.out.println("Não é subconjunto");    // Se o loop acabaou...
        return false;
    }
//**********************************************************************************

//******************************* QUESTAO 4 ***************************************

    public ConjGenerico<T> diferencaConjunto (ConjGenerico<T> conj2) {

        Elo p1 = this.prim, p2 = conj2.prim;
        Elo ult = null;
        Elo aux;

        ConjGenerico<T> diferenca = new ConjGenerico<>();

        while (p1 != null) {
            if (p1.dado.compareTo(p2.dado) == 0) {
                p1 = p1.prox;
                p2 = p2.prox;

            } else if (p1.dado.compareTo(p2.dado) < 0) {
                aux = new Elo(p1.dado);
                p1 = p1.prox;

                if (ult == null) {
                    diferenca.prim = aux;
                } else {
                    ult.prox = aux;
                }
                ult = aux;
            } else { // if prim2.dado.compareTo(prim1.dado) < 0
                p2 = p2.prox;
            }
        }
        return diferenca;
    }
//***********************************************************************************

//******************************** QUESTAO 5 **********************************

    boolean igualdadeConjuntos2(ConjGenerico<T> conj2) {
        return igualdadeConjuntosRec(this.prim, conj2.prim);
    }

    boolean igualdadeConjuntosRec(Elo prim1, Elo prim2) {
        if (prim1 == null && prim2 == null) { // caso ambas as listas estejam vazias
            System.out.println("Os conjuntos são iguais.");
            return true;
        }
        if (prim1 != null && prim2 != null) {
            return (prim1.dado == prim2.dado) && igualdadeConjuntosRec(prim1.prox, prim2.prox);
        }
        // falso caso uma das listas esteja vazia e a outra não
        System.out.println("Os conjuntos não são iguais.");
        return false;
    }

//******************************************************************************************************

//********************************************* QUESTAO 6 *******************************************


    // QUESTÃO 06 - LISTA 06
    public static ConjGenerico<Integer> calculaDeMorgan(ConjGenerico<Integer> A, ConjGenerico<Integer> B, ConjGenerico<Integer> universo) {

        ConjGenerico<Integer> compA;
        ConjGenerico<Integer> compB;
        ConjGenerico<Integer> intersec;

        // complemento de A
        compA = A.complementar(universo);

        System.out.println("Complementar de A:");
        compA.imprime();

        // complemento de B
        compB = B.complementar(universo);

        System.out.println("Complementar de B:");
        compB.imprime();

        // interseção dos complementos de A e B
        intersec = compA.intersecao(compB);

        return intersec;
    }





}




    
  



