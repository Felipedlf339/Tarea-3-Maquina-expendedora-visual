package org.example.modelo;
import java.util.ArrayList;

/**
 * Deposito genérico para almacenar cualquier tipo de objeto T.
 * @param <T> Tipo de objeto(Producto, Moneda, etc).
 */

public class Deposito<T> {
    private ArrayList<T> almacen;

    /**
     * Constructor que inicializa el depósito vacío.
     */
    public Deposito(){
        this.almacen = new ArrayList<T>();
    }

    /**
     * Agrega un elemento al deposito.
     * @param item el elemento a agregar
     */
    public void add(T item){
        this.almacen.add(item);
    }

    /**
     * Retorna el primer elemento del deposito
     * @return el primer elemento, o null si el deposito está vacío.
     */
    public T get(){
        if(almacen.isEmpty()) return null;
        return almacen.remove(0);
    }

}
