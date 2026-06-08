package org.example.vista;

import org.example.modelo.Deposito;
import org.example.modelo.Moneda;
import org.example.modelo.Producto;
import java.awt.*;

public class PanelDeposito<T> {
    private Deposito<T> deposito;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String etiqueta;

    public PanelDeposito(Deposito<T> deposito, int x, int y, int ancho, int alto, String etiqueta) {
        this.deposito = deposito;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.etiqueta = etiqueta;
        deposito.setXY(x, y);
    }

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

    public void paintComponent(Graphics g) {
        g.setColor(new Color(176, 216, 230, 80));
        g.fillRoundRect(x, y, ancho, alto, 12, 12);

        g.setColor(Color.CYAN);
        g.drawRoundRect(x, y, ancho, alto, 12, 12);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 11));
        g.drawString(etiqueta, x + 8, y - 6);

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