package org.example.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

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

    /**
     * Dibuja la moneda de 100 como un círculo de color cobre y su valor.
     * * @param g "pincel" que permite dibujar figuras, textos e imagenes en pantalla.
     */
    @Override
    public void paintComponent(Graphics g) {
        int diametro = 40;

        Color colorPlateado = new Color(192, 192, 192);
        Color plateadoOscuro = colorPlateado.darker().darker();

        g.setColor(colorPlateado);
        g.fillOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(plateadoOscuro);
        g.drawOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(plateadoOscuro);
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.drawString("$500", this.getX() + 6, this.getY() + 24);
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawString("s:" + this.getSerie(), this.getX() + 7, this.getY() + 32);
    }
}