package org.example.vista;

import org.example.modelo.Expendedor;
import org.example.modelo.Producto;
import org.example.modelo.Moneda;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PanelExpendedor extends JPanel {

    private Expendedor exp;

    private PanelDeposito<Producto> panelCoca;
    private PanelDeposito<Producto> panelSprite;
    private PanelDeposito<Producto> panelFanta;
    private PanelDeposito<Producto> panelSnickers;
    private PanelDeposito<Producto> panelSuper8;

    private PanelDeposito<Moneda> panelVuelto;

    public PanelExpendedor(Expendedor exp) {
        this.exp = exp;

        this.setBackground(Color.lightGray);

        int yRepisas = 60;
        int anchoRepisa = 75;
        int altoRepisa = 380;


        panelCoca = new PanelDeposito<>(exp.getDepCoca(), 70, yRepisas, anchoRepisa, altoRepisa, "Coca-Cola");
        panelSprite = new PanelDeposito<>(exp.getDepSprite(), 160, yRepisas, anchoRepisa, altoRepisa, "Sprite");
        panelFanta = new PanelDeposito<>(exp.getDepFanta(), 250, yRepisas, anchoRepisa, altoRepisa, "Fanta");
        panelSnickers = new PanelDeposito<>(exp.getDepSnickers(), 340, yRepisas, anchoRepisa, altoRepisa, "Snickers");
        panelSuper8 = new PanelDeposito<>(exp.getDepSuper8(), 430, yRepisas, anchoRepisa, altoRepisa, "Super 8");

        panelVuelto = new PanelDeposito<>(exp.getMonVuelto(), 430, 490, 100, 110, "Vuelto");

        actualizarPosiciones();
    }

    public void actualizarPosiciones() {
        panelCoca.setXY();
        panelSprite.setXY();
        panelFanta.setXY();
        panelSnickers.setXY();
        panelSuper8.setXY();
        panelVuelto.setXY();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(40, 20, 510, 610, 20, 20);

        g.setColor(Color.DARK_GRAY.darker());
        g.drawRoundRect(40, 20, 510, 610, 20, 20);

        g.setColor(new Color(173, 216, 230, 100));
        g.fillRoundRect(60, 60, 465, 380, 15, 15);

        g.setColor(Color.CYAN);
        g.drawRoundRect(60, 60, 465, 380, 15, 15);

        g.setColor(new Color(173, 216, 230, 100));
        g.fillRoundRect(430, 490, 100, 110, 10, 10);

        g.setColor(Color.CYAN);
        g.drawRoundRect(430, 490, 100, 110, 10, 10);

        panelCoca.paintComponent(g);
        panelSprite.paintComponent(g);
        panelFanta.paintComponent(g);
        panelSnickers.paintComponent(g);
        panelSuper8.paintComponent(g);

        panelVuelto.paintComponent(g);

        g.setColor(Color.DARK_GRAY.darker().darker());
        g.fillRoundRect(70, 490, 325, 110, 10, 10);

        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(70, 490, 325, 110, 10, 10);

        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("RETIRAR PRODUCTO", 140, 550);


        if (exp.getProductoComprado() != null) {
            Producto comprado = exp.getProductoComprado();
            comprado.setXY(205, 510);
            comprado.paintComponent(g);
        }
    }

    public PanelDeposito<Moneda> getPanelVuelto() {
        return panelVuelto;
    }
}