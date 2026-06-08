package org.example.modelo;
import java.util.ArrayList;

/**
 * Depósito genérico para almacenar cualquier tipo de objeto T.
 * Incluye coordenadas (x, y) para su representación gráfica.
 * @param <T> Tipo de objeto (Producto, Moneda, etc).
 */
public class Deposito<T> {
    private ArrayList<T> almacen;

    //Coordenada X e Y del depósito dentro de la ventana gráfica.
    private int x;
    private int y;

    /**
     * Constructor que inicializa el depósito vacío.
     */
    public Deposito() {
        this.almacen = new ArrayList<T>();
        this.x = 0;
        this.y = 0;
    }

    /**
     * Agrega un elemento al depósito.
     * @param item el elemento a agregar.
     */
    public void add(T item) {
        this.almacen.add(item);
    }

    /**
     * Retorna y elimina el primer elemento del depósito.
     * @return el primer elemento, o null si el depósito está vacío.
     */
    public T get() {
        if (almacen.isEmpty()) return null;
        return almacen.remove(0);
    }

    /**
     * Retorna el primer elemento sin eliminarlo (solo para consulta).
     * @return el primer elemento, o null si el depósito está vacío.
     */
    public T peek() {
        if (almacen.isEmpty()) return null;
        return almacen.get(0);
    }

    /**
     * Retorna la cantidad de elementos actualmente en el depósito.
     * @return número de elementos.
     */
    public int size() {
        return almacen.size();
    }

    /**
     * Indica si el depósito está vacío.
     * @return true si no hay elementos, false si hay al menos uno.
     */
    public boolean isEmpty() {
        return almacen.isEmpty();
    }

    /**
     * Retorna el elemento en la posición indicada sin eliminarlo.
     * @param index posición del elemento.
     * @return el elemento en esa posición.
     */
    public T getAt(int index) {return almacen.get(index);}

    /**
     * Establece la posición gráfica del depósito dentro de la ventana.
     * @param x coordenada horizontal en píxeles.
     * @param y coordenada vertical en píxeles.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna la coordenada X del depósito.
     * @return posición horizontal en píxeles.
     */
    public int getX() {return x;}

    /**
     * Retorna la coordenada Y del depósito.
     * @return posición vertical en píxeles.
     */
    public int getY() {
        return y;
    }
}