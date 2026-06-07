package org.example.modelo;

/**
 * Excepcion lanzada en caso de el valor de la moneda sea
 * menor al precio del producto solicitado
 */

public class PagoInsuficienteException extends Exception{
    /**
     * Constructor con el mensaje descriptivo del error
     * @param mensaje descripcion del motivo de la excepcion.
     */
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
