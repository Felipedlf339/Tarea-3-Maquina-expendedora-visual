package org.example.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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

    @Override
    public void paintComponent(Graphics g) {
        int diametro = 40;

        Color colorCobre = new Color(184, 115, 51);

        g.setColor(colorCobre);
        g.fillOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(colorCobre.darker());
        g.drawOval(this.getX(), this.getY(), diametro, diametro);
        g.setColor(colorCobre.darker());
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.drawString("$100", this.getX() + 6, this.getY() + 24);
    }
}