package org.example.modelo;

/**
 * Clase que representa un Snicker.
 * Hereda de Dulce e implenta consumir.
 */
public class Snickers extends Dulce {

    /**
     * Constructor que inicializa un Snickers con su número de serie.
     * @param serie número de serie del Snickers.
     */
    public Snickers(int serie) {
        super(serie); // Llama al constructor de la clase madre Dulce.
    }

    /**
     * Implementación de consumir un Snickers.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "snickers";
    }

}
