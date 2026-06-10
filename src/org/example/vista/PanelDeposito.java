package org.example.vista;

import org.example.modelo.Deposito;
import org.example.modelo.Moneda;
import org.example.modelo.Producto;
import java.awt.*;

/**
 * Clase que representa la interfaz grafica de un deposito en la maquina.
 * @param <T> El tipo de elemento contenedor, es decir, Producto o Moneda.
 */
public class PanelDeposito<T> {
    private Deposito<T> deposito;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String etiqueta;

    /**
     * Constructor de la clase PanelDeposito.
     * @param deposito el deposito instanciado.
     * @param x posición inicial horizontalmente.
     * @param y posición inicial verticalmente.
     * @param ancho el ancho en pixeles del deposito.
     * @param alto el alto en pixeles del deposito.
     * @param etiqueta nombre del producto.
     */
    public PanelDeposito(Deposito<T> deposito, int x, int y, int ancho, int alto, String etiqueta) {
        this.deposito = deposito;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.etiqueta = etiqueta;
        deposito.setXY(x, y);
    }

    /**
     * Calcula y asigna el lugar de cada elemento dentro del deposito.
     */
    public void setXY() {
        int cantidad = deposito.size();
        if (cantidad == 0) return;

        int elementoAlto = (deposito.getAt(0) instanceof Moneda) ? 40 : 70;
        int margenLateral = (ancho - 50) / 2;

        for (int i = 0; i < cantidad; i++) {
            T elem = deposito.getAt(i);
            int ex = this.x + margenLateral;
            int ey = this.y + this.alto - elementoAlto - 10 - (i * (elementoAlto + 5));

            if (elem instanceof Producto p) {
                p.setXY(ex, ey);
            } else if (elem instanceof Moneda m) {
                m.setXY(ex, ey);
            }
        }
    }

    /**
     * Dibuja la etiqueta del producto, el stock que hay y los productos o monedas.
     * @param g "pincel" que permite dibujar figuras, textos e imagenes en pantalla.
     */
    public void paintComponent(Graphics g) {

        // Dibuja la etiqueta del producto.
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.drawString(etiqueta, x + 8, y - 6);

        // Dibuja el stock que queda.
        int cantidad = deposito.size();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        g.drawString("Stock: " + cantidad, x + 5, y + alto + 14);

        if (cantidad == 0) {
            g.setColor(Color.PINK);
            g.setFont(new Font("Arial", Font.BOLD, 12));
            g.drawString("Sin stock", x + (ancho / 2) - 20, y + (alto / 2));
            return;
        }

        // Dibuja los productos o monedas.
        for (int i = 0; i < cantidad; i++) {
            T elem = deposito.getAt(i);
            if (elem instanceof Producto p) {
                p.paintComponent(g);
            } else if (elem instanceof Moneda m) {
                m.paintComponent(g);
            }
        }
    }
}