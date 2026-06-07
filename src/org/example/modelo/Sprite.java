package org.example.modelo;

/**
 * Clase que representa una Sprite.
 * Hereda de Bebida e implenta consumir.
 */
public class Sprite extends Bebida{

    /**
     * Constructor que inicializa una Sprite con su número de serie.
     * @param serie número de serie de la Sprite.
     */
    public Sprite(int serie) {
        super(serie); // Llama al constructor de la clase madre Bebida.
    }

    /**
     * Implementación de consumir una Coca-Cola.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "sprite";
    }
}
