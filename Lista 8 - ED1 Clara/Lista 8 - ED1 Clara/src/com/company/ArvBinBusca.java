package com.company;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> 
{
	private No raiz; /* Raiz da �rvore. */

	private class No
	{
		private Chave chave; /* Chave usada nas compara��es. */
		private Valor valor; /* Informa��o armazenada. */
		private No esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

		/* Cria um n� com chave e valor fornecidos e esq = dir = null. */
		public No(Chave chave, Valor valor)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = null;
			this.dir = null;
		}
		
		/* Cria um n� com chave e valor fornecidos. As sub�rvores esq e dir s�o
		 * passadas por par�metro. */
		public No(Chave chave, Valor valor, No esq, No dir)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	/**
	 *  Cria��o de uma �rvore vazia. 
	 */
	public ArvBinBusca()
	{
		raiz = null;
	}
	
	/** 
	 * Verifica se a �rvore est� vazia.
	 * 
	 * @return se a �rvore est� vazia ou possui algum elemento
	 */
	public boolean vazia()
	{
		return (raiz == null);
	}
	
	/**
	 * Apresenta o conte�do da �rvore em ordem sim�trica.
	 */
	public void mostra()
	{
		mostra(raiz);
	}
	
	private void mostra(No x)
	{
		/* Caso base (crit�rio de parada). */
		if(x == null)
			return;
		
		System.out.print("[");
		
		/* Chamada recursiva para a esquerda. */
		mostra(x.esq);
		
		/* Imprime a chave do n� corrente. */
		System.out.print("<" + x.chave + ">");
		
		/* Chamada recursiva para a direita. */
		mostra(x.dir);
		
		System.out.print("]");
	}
	
    /**
     * Retorna a menor chave da �rvore.
     *
     * @return a menor chave da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave min()
    {
        if(vazia()) 
        	throw new NoSuchElementException("�rvore est� vazia!");
        
        return min(raiz).chave;
    } 

    private No min(No x) { 
        if (x.esq == null) 
        	return x; 
        else
        	return min(x.esq); 
    }
    
    /**
     * Retorna o maior elemento da �rvore.
     *
     * @return o maior elemento da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave max() {
        if(vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        return max(raiz).chave;
    } 

    private No max(No x) {
        if (x.dir == null)
        	return x; 
        else
        	return max(x.dir); 
    }
    
    /**
     * Retorna o n�mero de n�s, isto �, pares (chave, valor), contidos na �rvore 
     * bin�ria de busca.
     * 
     * @return o n�mero de n�s da �rvore
     */
    public int tamanho()
    {
    	return tamanho(raiz);
    }
    
    private int tamanho(No x)
    {
    	/* Caso base (crit�rio de parada). */
    	if(x == null)
    		return 0;
    	
    	/* Chamada recursiva para sub�rvores esquerda e direita. */
    	return 1 + tamanho(x.esq) + tamanho(x.dir);
    }
    
    
    /**
     * Retorna a altura da �rvore bin�ria de busca.
     *
     * @return a altura da �rvore (uma �rvore de um �nico n� possui altura 0)
     */
    public int altura()
    {
    	return altura(raiz);
    }
    
    private int altura(No x)
    {
    	if(x == null)
    		return -1;
    	
    	int maxAltura = Math.max(altura(x.esq), altura(x.dir));
    	
    	return 1 + maxAltura;
    }
    
    
    /**
     * Essa �rvore bin�ria de busca cont�m a chave fornecida?
     *
     * @param  chave a chave fornecida
     * @return {@code true} se a �rvore cont�m a chave {@code chave} e
     *         {@code false} caso contr�rio
     * @throws IllegalArgumentException se {@code key} � {@code null}
     */
    public boolean contem(Chave chave) {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        return get(chave) != null;
    }
	
    /**
     * Retorna o valor associado � chave fornecida.
     *
     * @param  chave a chave a ser buscada
     * @return o valor associado � chave fornecida se tal chave se encontra na �rvore
     *         e {@code null} se a chave n�o est� na �rvore
     * @throws IllegalArgumentException if {@code chave} is {@code null}
     */
    public Valor get(Chave chave) 
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave) 
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        /* A chave n�o se encontra na �rvore. */
        if(x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	return get(x.dir, chave);
        else /* Chave encontrada. */
        	return x.valor;
    }
    
    /**
     * Insere na �rvore bin�ria de busca o par (chave, valor) fornecido. Caso a �rvore
     * j� possua a chave especificada, o valor antigo � sobrescrito com o novo valor 
     * fornecido. Remove o n� de chave igual � chave fornecida caso o valor especificado
     * seja {@code null}.
     *
     * @param  chave a chave fornecida
     * @param  valor o valor fornecido
     * @throws IllegalArgumentException se {@code chave} � {@code null}
     */
    public void put(Chave chave, Valor valor)
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if(valor == null) {
            delete(chave);
            return;
        }
        
        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
    	/* Caso base: encontrou a posi��o de inser��o. */
        if (x == null)
        	return new No(chave, valor);
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado n� de mesma chave. */
        	x.valor = valor;
        
        return x;
    }
	
    /**
     * Remove o n� de menor chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMin() 
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMin(raiz);
    }

    /* M�todo recursivo que anda sempre para a esquerda, procurando o n�
     * de menor chave a ser removido. */
    private No deleteMin(No x) 
    {
    	/* Caso n�o haja filho � esquerda, o n� corrente possui a menor chave. */
        if(x.esq == null) 
        	return x.dir;
        
        x.esq = deleteMin(x.esq);
        
        return x;
    }

    /**
     * Remove o n� de maior chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMax()
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMax(raiz);
    }

    /* M�todo recursivo que anda sempre para a direita, procurando o n�
     * de maior chave a ser removido. */
    private No deleteMax(No x) 
    {
        if(x.dir == null)
        	return x.esq;
        
        x.dir = deleteMax(x.dir);
        
        return x;
    }
    
    /**
     * Remove o n� cuja chave seja igual � {@code chave} fornecida.
     * 
     * @param chave a chave fornecida
     * @return {@code true} se foi poss�vel remover o n� de chave {@code chave} e
     *         {@code false} caso contr�rio
     */
    public void delete(Chave chave)
    {    	
    	raiz = delete(raiz, chave);    	
    }
    
    /* Remove o n� com o valor "val" da "�rvore" a partir do n� para o qual est� sendo chamada a fun��o. Obs: "ref_no" � o ponteiro que referencia o n� para o qual est� sendo chamada a fun��o, o qual pode ter que ser modificado. Retorna false se o valor n�o pertencer � "�rvore".
    */
    private No delete(No x, Chave chave)
    {
    	if (x == null)
    		return null;

    	int cmp = chave.compareTo(x.chave);
    	
    	if(cmp < 0)
    		x.esq = delete(x.esq, chave);
    	else if(cmp > 0)
    		x.dir = delete(x.dir, chave);
    	else
    	{ 
    		if(x.dir == null)
    			return x.esq;
    		if(x.esq  == null)
    			return x.dir;
    		
    		No t = x;

    		/* Pega o menor da sub�rvore direita (mais � esquerda). */
    		x = min(t.dir);

    		/* Remove o menor. */
    		x.dir = deleteMin(t.dir);

    		/* A sub�rvore esquerda se mant�m a mesma. */
    		x.esq = t.esq;
    	}

    	return x;
    }
    
    
    /**
     * Retorna a maior chave na �rvore que � menor ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a maior chave na �rvore menor ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave piso(Chave chave)
    {
        if (chave == null)
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if (vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = piso(raiz, chave);
        
        if (x == null)
        	return null;
        else
        	return x.chave;
    } 

    private No piso(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp <  0)
        	return piso(x.esq, chave);
        
        No t = piso(x.dir, chave);

        if (t != null) 
        	return t;
        else
        	return x; 
    }

    
    /**
     * Retorna a menor chave na �rvore que � maior ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a menor chave na �rvore maior ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave topo(Chave chave)
    {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = topo(raiz, chave);
        
        if (x == null)
        	return null;
        else 
        	return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp < 0)
        { 
            No t = topo(x.esq, chave);
            
            if (t != null)
            	return t;
            else
            	return x; 
        } 
        
        return topo(x.dir, chave); 
    } 
    

    public int rank(Chave chave) {
    	/* O aluno deve fazer como exerc�cio. */
    	return 0;
    } 

    // N�mero de chaves na sub�rvore que s�o estritamente menores do que chave.
    private int rank(Chave chave, No x) {
    	/* O aluno deve fazer como exerc�cio. */
    	return 0;
    }


	//************************* QUESTÃO 2 ****************************************

    /**
     * A partir de um vetor de inteiros, cria uma arvore binaria de busca
     * Complexidade O(x)
     */
	public void constroiArvore(int[] vetor) {
    	for(Integer x : vetor) {
    		this.put((Chave)x,(Valor)x);
    	}
    	
    }

	//************************** questao 3 ******************************************
    /**
     Complexidade O(nos)
     */
	public void transformaBST(Arvbin<Chave> arvoreBinaria) {
    	this.put((Chave)arvoreBinaria.retornaVal(), (Valor)arvoreBinaria.retornaVal());
    	
		if (arvoreBinaria.retornaEsq() != null)
			transformaBST(arvoreBinaria.retornaEsq());
		if (arvoreBinaria.retornaDir() != null)
			transformaBST(arvoreBinaria.retornaDir());
		
    	
    }

	//************************* QUESTAO 4 **********************************
    /**
      Complexidade O(log altura) OU Complexidade O(altura)
       */
    public boolean removeForaIntervalo(Chave chaveMin, Chave chaveMax) {
    	Boolean mod = false;

    	No aux = raiz;
    	while(aux.chave.compareTo(chaveMax) < 0 || aux.chave.compareTo(chaveMax) > 0) {
    		if(aux.chave.compareTo(chaveMax) < 0) {
    			aux = aux.dir;
        		if(aux.dir == null) {
        			break;
        		}
    		}else if(aux.chave.compareTo(chaveMax) > 0) {
    			aux = aux.esq;
        		if(aux.esq == null) {
        			break;
        		}
    		}
    	}
		if(aux.chave.compareTo(chaveMax) == 0) {
    		
    		if(aux.dir != null) {
    			aux.dir = null;
    			mod = true;
    		}
		aux = raiz;
    	while(aux.chave.compareTo(chaveMin) > 0 || aux.chave.compareTo(chaveMin) < 0) {
    		if(aux.chave.compareTo(chaveMin) > 0) {
    			aux = aux.esq;
        		if(aux.esq == null) {
        			break;
        		}
    		}else if(aux.chave.compareTo(chaveMin) < 0) {
    			aux = aux.dir;
        		if(aux.dir == null) {
        			break;
        		}
    		}
    	}
		if(aux.chave.compareTo(chaveMin) == 0) {
    		
    		if(aux.esq != null) {
    			aux.esq = null;
    			mod = true;
    		}
    		if(aux.chave.compareTo(raiz.chave) > 0)
    			raiz = aux;		// Fooii
    	}
    		
    	}
		else if(aux.chave.compareTo(chaveMin) > 0) {
			aux.esq = null;
    		if(aux.chave.compareTo(raiz.chave) < 0)
    			raiz = aux;
    	}
    	return mod;
    }

//************************* QUESTÃO 5 *********************************

    /**
     Complexidade O(log altura) OU Complexidade O(nos)
    */
    public No obtemAncestralComum(No primeiroNo, No segundoNo) { // 
    	No aux,no1,no2;
    	aux = raiz;
    	Queue<No> fila = new LinkedList<>();
    	fila.add(raiz.esq);
    	fila.add(raiz.dir);
    	while(!fila.isEmpty()) { // Enquanto a filar nao estiver vazia
    		no1 = fila.peek();
    		fila.remove();
    		no2 = fila.peek();
    		if(!fila.isEmpty())
    			fila.remove();
    		
    		if(no1 != null) {
    			if(no1.esq != null ) { // se os nos parentes forem menor ou maior que o no pai
    				if(primeiroNo.chave.compareTo(no1.chave) < 0 && segundoNo.chave.compareTo(no1.chave) < 0) {
    					if(primeiroNo.chave.compareTo(no1.esq.chave) == 0)
    						return no1;				
    					if(segundoNo.chave.compareTo(no1.esq.chave) == 0)
    						return no1;
    				}
            			
    			}if(no1.dir != null ) {// se os nos parentes forem menor ou maior que o no pai
    				if(primeiroNo.chave.compareTo(no1.chave) > 0 && segundoNo.chave.compareTo(no1.chave) > 0) {
    					if(primeiroNo.chave.compareTo(no1.dir.chave) == 0)
    						return no1;	
    					if(segundoNo.chave.compareTo(no1.dir.chave) == 0)
						return no1;
    				}
    			}
    			if(no1.esq != null && no1.dir != null ) { // Se este � o ponto em comum
    				if(primeiroNo.chave.compareTo(no1.chave) > 0 && segundoNo.chave.compareTo(no1.chave) < 0) 
            			return no1;
    				if(primeiroNo.chave.compareTo(no1.chave) < 0 && segundoNo.chave.compareTo(no1.chave) > 0) 
            			return no1;
    			}
    		}
    		
    		
    		if(no2 != null) {
    			if(no2.esq != null ) { // se os nos parentes forem menor ou maior que o no pai
    				if(primeiroNo.chave.compareTo(no2.chave) < 0 && segundoNo.chave.compareTo(no2.chave) < 0) {
    					if(primeiroNo.chave.compareTo(no2.esq.chave) == 0)
    						return no2;	
    					if(segundoNo.chave.compareTo(no2.esq.chave) == 0)
    						return no2;
    				}
            			
    			}if(no2.dir != null ) { // se os nos parentes forem menor ou maior que o no pai
    				if(primeiroNo.chave.compareTo(no2.chave) > 0 && segundoNo.chave.compareTo(no2.chave) > 0) {
    					if(primeiroNo.chave.compareTo(no2.dir.chave) == 0)
    						return no2;	
    					if(segundoNo.chave.compareTo(no2.dir.chave) == 0)
    						return no2;	
    				}
    				
    			}
    			if(no2.esq != null && no2.dir != null ) { //Se este � o ponto em comum
    				if(primeiroNo.chave.compareTo(no2.chave) > 0 && segundoNo.chave.compareTo(no2.chave) < 0) 
            			return no2;
    				if(primeiroNo.chave.compareTo(no2.chave) < 0 && segundoNo.chave.compareTo(no2.chave) > 0) 
            			return no2;
    			}
    		}
    		
    		if(no1 != null) {  // se for menor ou maior que a chave do atual, adicionar a fila
    			if (no1.esq != null && primeiroNo.chave.compareTo(no1.chave) < 0 || no1.esq != null && segundoNo.chave.compareTo(no1.chave) < 0)
    				fila.add(no1.esq);

    			if (no1.dir != null && segundoNo.chave.compareTo(no1.chave) > 0 || no1.dir != null && primeiroNo.chave.compareTo(no1.chave) > 0)
    				fila.add(no1.dir);
    		}
    		if(no2 != null) {
    			if (no2.esq != null && primeiroNo.chave.compareTo(no2.chave) < 0 || no2.esq != null && segundoNo.chave.compareTo(no2.chave) < 0)
    				fila.add(no2.esq);

    			if (no2.dir != null && segundoNo.chave.compareTo(no2.chave) > 0 || no2.dir != null && primeiroNo.chave.compareTo(no2.chave) > 0)
    				fila.add(no2.dir);

    		}
    	}
    	return aux; // se nao achar retorna o no raiz
    }

      //Obtem um n� passado por parametro
     // Complexidade melhor caso O(altura)

    public No getNo(Chave chave) { 
		No aux;
		Queue<No> fila = new LinkedList<>();
		if(raiz.chave.compareTo(chave) == 0) {
			return raiz;
		}else if(raiz.chave.compareTo(chave) > 0) {
			fila.add(raiz.esq);
		}else {
			fila.add(raiz.dir);
		}
    	
		while(!fila.isEmpty()) {
			aux = fila.peek();
    		fila.remove();
    		
    		
    		if(aux.chave.compareTo(chave) == 0) 
    			return aux;
    		
    		if (aux.chave.compareTo(chave) > 0 || aux.esq != null)
				fila.add(aux.esq);

			if (aux.chave.compareTo(chave) < 0 ||aux.dir != null)
				fila.add(aux.dir);
    	}
			return raiz;
	}
    /*
     valor da chave do n�
     */
    public void printNo(No no) {
    	System.out.print(no.chave);
    }


}