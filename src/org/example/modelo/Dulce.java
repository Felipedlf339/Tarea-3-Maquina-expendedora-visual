package org.example.modelo;

/**
 * Clase abstracta que representa dulces.
 * Hereda de Producto, sirviendo como base para los tipos de dulces concretos.
 */
public abstract class Dulce extends Producto {

    /**
     * Constructor que inicializa el dulce con su número de serie.
     * @param serie número de serie del dulce.
     */
    public Dulce(int serie) {
        super(serie); // Pasa la serie a la clase madre Producto.
    }
}
