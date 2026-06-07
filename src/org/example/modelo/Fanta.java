package org.example.modelo;

/**
 * Clase que representa una Fanta.
 * Hereda de Bebida e implenta consumir.
 */
public class Fanta extends Bebida {

    /**
     * Constructor que inicializa una Fanta con su número de serie.
     * @param serie número de serie de la Fanta.
     */
    public Fanta(int serie) {
        super(serie); // Llama al constructor de la clase madre Bebida.
    }

    /**
     * Implementación de consumir una Fanta.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "fanta";
    }
}