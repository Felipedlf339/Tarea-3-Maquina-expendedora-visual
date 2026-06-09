package org.example.modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Clase que representa un Super8.
 * Hereda de Dulce e implenta consumir.
 */
public class Super8 extends Dulce {

    private Image imagen;

    /**
     * Constructor que inicializa un Super8 con su número de serie.
     * Intenta cargar su imagen.
     * @param serie número de serie del Super8.
     */
    public Super8(int serie) {
        super(serie);
        try {
            this.imagen = new ImageIcon(getClass().getResource("/imagenes/super8.png")).getImage();
        } catch (Exception e) {
            System.out.println("La imagen no se ha encontrado");
        }
    }

    /**
     * Implementación de consumir un Super8.
     * @return una cadena de texto que indica el producto consumido.
     */
    @Override
    public String consumir() {
        return "super8";
    }

    /**
     * Dibuja el producto en la interfaz.
     * Muestra la imagen cargada o un rectángulo rosa si esta no carga.
     * * @param g "pincel" que permite dibujar figuras, textos e imagenes en pantalla.
     */
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
