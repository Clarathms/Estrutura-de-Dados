package com.company;

import java.util.Objects;

public class PilhaFilha <T> extends PilhaGenerica <T> {

    private T obj;

    //Construtores
    public PilhaFilha(){
        super();
    }

    public PilhaFilha(int capacidade ){
        super(capacidade);
    }

    // Atribui e empilha os objetos
    public PilhaFilha(T valor){
        this.obj = valor;

    }
    public void Obj (T valor) {
        this.obj = valor;
        push(obj);
    }

    //Empilha e desempilha
    public void push(T elemento){
        super.adiciona(elemento);
    }

    public void pop(){
        super.remove();
    }

    //Método equals

    @Override
    public boolean equals(Object o) {       // Verifica se obj1 == obj2
        if (this == o)
            return true;
        if (!(o instanceof PilhaFilha))
            return false;
        PilhaFilha<T> that = (PilhaFilha<T>) o;
        return Objects.equals(obj, that.obj);
    }


}
