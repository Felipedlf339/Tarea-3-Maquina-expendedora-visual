package org.example.modelo;

/**
 * Clase abstracta que representa una bebida.
 * Hereda de Producto, sirviendo como base para los tipos de bebidas concretas.
 */
public abstract class Bebida extends Producto {

    /**
     * Constructor que inicializa la bebida con su número de serie.
     * @param serie número de serie de la bebida.
     */
    public Bebida(int serie) {
        super(serie); // Pasa la serie a la clase madre Producto.
    }

}
