package org.example.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


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

    /**
     * Dibuja la moneda de 100 como un círculo de color cobre y su valor.
     * * @param g "pincel" que permite dibujar figuras, textos e imagenes en pantalla.
     */
    @Override
    public void paintComponent(Graphics g) {
        int diametro = 40;

        Color colorOro = new Color(255, 215, 0);
        Color oroOscuro = colorOro.darker().darker();

        g.setColor(colorOro);
        g.fillOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(oroOscuro);
        g.drawOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(oroOscuro);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("$1000", this.getX() + 3, this.getY() + 24);
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        g.drawString("s:" + this.getSerie(), this.getX() + 7, this.getY() + 32);
    }
}