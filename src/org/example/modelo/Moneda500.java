package org.example.modelo;

/**
 * Representa una moenda de $500
 * Puede utilizarse como pago en Expendedor.
 */

public class Moneda500 extends Moneda {
    /**
     * Constructor de la moneda de $500
     */
    public Moneda500() {
        super();
    }

    /**
     * Retorna el valor de la moneda
     * @return 500
     */
    @Override
    public int getValor() {
        return 500;
    }
}