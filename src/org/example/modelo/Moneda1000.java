package org.example.modelo;

/**
 * Representa una moneda de $1000
 * Puede utilizarse como medio de pago en Expendedor.
 */

public class Moneda1000 extends Moneda {
    /**
     * Constructor de la moneda de $1000.
     */
    public Moneda1000() {
        super();
    }

    /**
     * Retorna el valor de la moneda
     * @return 1000
     */
    @Override
    public int getValor() {
        return 1000;
    }
}