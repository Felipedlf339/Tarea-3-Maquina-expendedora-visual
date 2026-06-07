package org.example.modelo;

/**
 * Excepcion lanzada cuando no hay stock de un producto
 * o el identificador del producto no coincide con ningun deposito.
 */

public class NoHayProductoException extends Exception{
    /**
     * Constructor con mensaje del error.
     * @param mensaje descripcion del motivo de la excepcion.
     */
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}
