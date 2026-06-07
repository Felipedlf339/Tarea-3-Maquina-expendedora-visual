package org.example.modelo;

/**
 * Clase que representa un Super8.
 * Hereda de Dulce e implenta consumir.
 */
public class Super8 extends Dulce {

    /**
     * Constructor que inicializa un Super8 con su número de serie.
     * @param serie número de serie del Super8.
     */
    public Super8(int serie) {
        super(serie); // Llama al constructor de la clase madre Dulce.
    }

    /**
     * Implementación de consumir un Super8.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "super8";
    }
}
