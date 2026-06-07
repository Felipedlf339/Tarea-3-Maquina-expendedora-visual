package org.example.modelo;

/**
 * Clase que representa una Coca-Cola.
 * Hereda de Bebida e implenta consumir.
 */
public class CocaCola extends Bebida {

    /**
     * Constructor que inicializa una Coca-Cola con su número de serie.
     * @param serie número de serie de la Coca-Cola.
     */
    public CocaCola(int serie) {
        super(serie); // Llama al constructor de la clase madre Bebida.
    }

    /**
     * Implementación de consumir una Coca-Cola.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "cocacola";
    }
}
