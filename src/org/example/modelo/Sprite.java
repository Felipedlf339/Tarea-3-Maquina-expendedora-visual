package org.example.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase que representa una Sprite.
 * Hereda de Bebida e implenta consumir.
 */
public class Sprite extends Bebida{

    private Image imagen;

    public Sprite(int serie) {
        super(serie);
        try {
            this.imagen = new ImageIcon(getClass().getResource("/imagenes/sprite.png")).getImage();
        } catch (Exception e) {
            System.out.println("La imagen no se ha encontrado");
        }
    }

    @Override
    public String consumir() {
        return "sprite";
    }

    @Override
    public void paintComponent(Graphics g) {
        int ancho = 50;
        int alto = 70;

        if (imagen != null) {
            g.drawImage(imagen, this.getX(), this.getY(), ancho, alto, null);
        } else {
            g.setColor(Color.PINK);
            g.fillRect(this.getX(), this.getY(), ancho, alto);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("#" + this.getSerie(), this.getX() + 5, this.getY() + alto / 2);
    }
}
