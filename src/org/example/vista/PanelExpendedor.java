package org.example.vista;

import org.example.modelo.Expendedor;
import org.example.modelo.Producto;
import org.example.modelo.Moneda;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Clase encargada de la vista del expendedor.
 */
public class PanelExpendedor extends JPanel {

    private Expendedor exp;

    private PanelDeposito<Producto> panelCoca;
    private PanelDeposito<Producto> panelSprite;
    private PanelDeposito<Producto> panelFanta;
    private PanelDeposito<Producto> panelSnickers;
    private PanelDeposito<Producto> panelSuper8;

    private PanelDeposito<Moneda> panelVuelto;

    /**
     * Constructor del panel expendedor.
     * Define medidas y conecta cada repisa con su deposito correspondiente.
     * @param exp instancia del expendedor.
     */
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

    /**
     * Actualiza la posición de productos y monedas en la maquina.
     */
    public void actualizarPosiciones() {
        panelCoca.setXY();
        panelSprite.setXY();
        panelFanta.setXY();
        panelSnickers.setXY();
        panelSuper8.setXY();
        panelVuelto.setXY();
    }

    /**
     * Dibuja como se verá la maquina expendedora, repisas, productos, cristal, entre otros.
     * @param g "pincel" que permite dibujar figuras, textos e imagenes en pantalla.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja el exterior.
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(40, 20, 510, 610, 20, 20);

        g.setColor(Color.DARK_GRAY.darker());
        g.drawRoundRect(40, 20, 510, 610, 20, 20);

        // Dibuja el vidrio.
        g.setColor(new Color(173, 216, 230, 100));
        g.fillRoundRect(60, 60, 465, 380, 15, 15);

        g.setColor(Color.CYAN);
        g.drawRoundRect(60, 60, 465, 380, 15, 15);

        // Vidrio de la caja de vuelto.
        g.setColor(new Color(173, 216, 230, 100));
        g.fillRoundRect(430, 490, 100, 110, 10, 10);

        g.setColor(Color.CYAN);
        g.drawRoundRect(430, 490, 100, 110, 10, 10);

        // Dibuja productos y monedas.
        panelCoca.paintComponent(g);
        panelSprite.paintComponent(g);
        panelFanta.paintComponent(g);
        panelSnickers.paintComponent(g);
        panelSuper8.paintComponent(g);

        panelVuelto.paintComponent(g);

        // Donde se retira el producto.
        g.setColor(Color.DARK_GRAY.darker().darker());
        g.fillRoundRect(70, 490, 325, 110, 10, 10);

        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(70, 490, 325, 110, 10, 10);

        // Texto de la caja donde se retira el producto.
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("RETIRAR PRODUCTO", 140, 550);

        // Detecta y dibuja el producto comprado.
        if (exp.getProductoComprado() != null) {
            Producto comprado = exp.getProductoComprado();
            comprado.setXY(205, 510);
            comprado.paintComponent(g);
        }
    }

    /**
     * Getter del panel del vuelto.
     * @return el PanelDeposito del vuelto.
     */
    public PanelDeposito<Moneda> getPanelVuelto() {
        return panelVuelto;
    }

    /**
     * Revisa si el clic del mouse está dentro del área visual del expendedor.
     * Permite retirar productos, retirar vuelto, o rellenar la máquina al tocar el vidrio.
     */
    public void verificarClic(int x, int y) {

        // 1. ZONA DE RETIRAR PRODUCTO
        if (x >= 70 && x <= 395 && y >= 490 && y <= 600) {
            Producto p = exp.getProducto();
            if (p != null) {
                System.out.println("Retiraste de la máquina: " + p.getClass().getSimpleName());

                PanelComprador.mensajeEstado = "Retiraste: " + p.getClass().getSimpleName();
            }
        }

        // 2. ZONA DE RETIRAR VUELTO
        else if (x >= 430 && x <= 530 && y >= 490 && y <= 600) {
            Moneda m = exp.getVuelto();
            if (m != null) {
                System.out.println("Retiraste vuelto de la máquina: $" + m.getValor());

                PanelComprador.mensajeEstado = "Retiraste vuelto: $" + m.getValor();
            }
        }

        // 3. ZONA DEL VIDRIO
        else if (x >= 0 && x <= 600 && y >= 0 && y < 490) {

            // REVISAMOS SI ESTÁ VACÍO
            boolean necesitaRelleno = exp.getDepCoca().size() == 0 ||
                    exp.getDepSprite().size() == 0 ||
                    exp.getDepFanta().size() == 0 ||
                    exp.getDepSnickers().size() == 0 ||
                    exp.getDepSuper8().size() == 0;

            // NECESITA RELLENO
            if (necesitaRelleno) {
                try {
                    exp.rellenarDepositosVacios(5);
                    this.actualizarPosiciones();

                    PanelComprador.mensajeEstado = "Máquina rellenada con éxito.";
                } catch (Exception e) {
                    System.out.println("Error al rellenar: " + e.getMessage());
                    PanelComprador.mensajeEstado = e.getMessage();
                }
            }

            // NO NECESITA RELLENO
            else {
                PanelComprador.mensajeEstado = "Stock suficiente. No es necesario rellenar.";
            }
        }
    }

}