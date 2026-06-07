package org.example.modelo;

/**
 * Excepcion lanzada en caso de que se intente realizar una compra sin
 * entregar una moneda (moneda null).
 */

public class PagoIncorrectoException extends Exception{
    /**
     * Constructor con mensaje del error
     * @param mensaje descripcion del motivo de la excepcion.
     */
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}
