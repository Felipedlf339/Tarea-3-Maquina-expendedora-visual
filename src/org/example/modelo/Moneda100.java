package org.example.modelo;

/**
 * Representa una moneda de 100
 * Es la moneda usada para entregar el vuelto en Expendedor.
 */

public class Moneda100 extends Moneda {
    /**
     * Constructor de la moneda de $100
     */
    public Moneda100() {
        super();
    }

    /**
     * Retorna el valor de la moneda
     * @return 100
     */
    @Override
    public int getValor() {
        return 100;
    }
}