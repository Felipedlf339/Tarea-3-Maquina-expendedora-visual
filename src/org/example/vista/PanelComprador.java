package org.example.vista;
import org.example.modelo.*;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Clase que representa la interfaz gráfica del comprador.
 * Administra las zonas de selección de monedas y productos,
 * gestiona los clics para interactuar con el expendedor y retirar compras.
 */
public class PanelComprador extends JPanel {

    private Expendedor expendedor;
    private Moneda monedaSeleccionada = null;

    public static String mensajeEstado = "Esperando instrucción...";

    private final int botonX = 650;
    private final int botonAncho = 120;
    private final int botonAlto = 40;

    /**
     * Constructor de la clase PanelComprador.
     * Inicializa la vista del comprador y la enlaza con la parte lógica de la máquina.
     * @param expendedor Instancia lógica de la máquina expendedora con la que se interactuará.
     */
    public PanelComprador(Expendedor expendedor) {
        this.expendedor = expendedor;
    }

    /**
     * Dibuja los componentes visuales del panel del comprador.
     * Renderiza las opciones de monedas, el catálogo de productos, el estado
     * actual de la moneda seleccionada y la zona de retiro del producto.
     * @param g El contexto gráfico utilizado para pintar en el panel.
     */
    @Override
    public void paintComponent(Graphics g) {
        // SECCIÓN DE MONEDAS
        g.setColor(Color.BLACK);
        g.drawString("1. SELECCIONE LA MONEDA A USAR:", botonX, 50);

        g.setColor(new Color(205, 127, 50));
        g.fillOval(botonX, 70, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(botonX, 70, 60, 60);
        g.drawString("$100", botonX + 15, 105);

        g.setColor(new Color(212, 175, 55));
        g.fillOval(botonX + 80, 70, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(botonX + 80, 70, 60, 60);
        g.drawString("$500", botonX + 95, 105);

        g.setColor(new Color(143, 188, 143));
        g.fillOval(botonX + 160, 70, 60, 60);
        g.setColor(Color.BLACK);
        g.drawOval(botonX + 160, 70, 60, 60);
        g.drawString("$1000", botonX + 165, 105);


        g.setColor(Color.BLUE);
        if (monedaSeleccionada != null) {
            g.drawString("Moneda seleccionada: $" + monedaSeleccionada.getValor(), botonX, 150);
        } else {
            g.drawString("Moneda seleccionada: Ninguna", botonX, 150);
        }

        // SECCIÓN DE PRODUCTOS
        g.setColor(Color.BLACK);
        g.drawString("2. SELECCIONE PRODUCTO PARA COMPRAR:", botonX, 180);

        g.setColor(Color.RED); g.fillRect(botonX, 190, botonAncho, botonAlto);
        g.setColor(Color.WHITE); g.drawString("Coca-Cola", botonX + 30, 215);

        g.setColor(Color.GREEN); g.fillRect(botonX, 240, botonAncho, botonAlto);
        g.setColor(Color.BLACK); g.drawString("Sprite", botonX + 40, 265);

        g.setColor(Color.ORANGE); g.fillRect(botonX, 290, botonAncho, botonAlto);
        g.setColor(Color.BLACK); g.drawString("Fanta", botonX + 40, 315);

        g.setColor(new Color(139, 69, 19)); g.fillRect(botonX, 340, botonAncho, botonAlto);
        g.setColor(Color.WHITE); g.drawString("Snickers", botonX + 35, 365);

        g.setColor(Color.YELLOW); g.fillRect(botonX, 390, botonAncho, botonAlto);
        g.setColor(Color.BLACK); g.drawString("Super 8", botonX + 35, 415);

        // SECCIÓN DE MENSAJES
        g.setColor(Color.BLACK);
        g.drawString("3. ESTADO DE LA COMPRA:", botonX, 470);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(botonX, 480, 320, 40);
        g.setColor(Color.GREEN);
        g.drawString(mensajeEstado, botonX + 10, 505);
    }

    /**
     * Evalúa las coordenadas de un clic para determinar la acción del comprador.
     * Gestiona la selección de monedas, el envío de la orden de compra al expendedor
     * y el retiro de productos o vuelto desde las bandejas.
     * @param x La coordenada X donde se registró el clic del mouse.
     * @param y La coordenada Y donde se registró el clic del mouse.
     */
    public void verificarClic(int x, int y) {

        // CLIC EN MONEDAS
        if (y >= 70 && y <= 130) {
            if (x >= botonX && x <= botonX + 60) {
                monedaSeleccionada = new Moneda100();
                mensajeEstado = "Moneda de $100 tomada.";
            } else if (x >= botonX + 80 && x <= botonX + 140) {
                monedaSeleccionada = new Moneda500();
                mensajeEstado = "Moneda de $500 tomada.";
            } else if (x >= botonX + 160 && x <= botonX + 220) {
                monedaSeleccionada = new Moneda1000();
                mensajeEstado = "Moneda de $1000 tomada.";
            }
        }

        // CLIC EN PRODUCTOS
        if (x >= botonX && x <= (botonX + botonAncho) && y >= 190 && y <= 430) {
            if (monedaSeleccionada != null) {
                try {
                    if (y >= 190 && y <= 230) {
                        expendedor.comprarProducto(monedaSeleccionada, Catalogo.COCACOLA);
                    } else if (y >= 240 && y <= 280) {
                        expendedor.comprarProducto(monedaSeleccionada, Catalogo.SPRITE);
                    } else if (y >= 290 && y <= 330) {
                        expendedor.comprarProducto(monedaSeleccionada, Catalogo.FANTA);
                    } else if (y >= 340 && y <= 380) {
                        expendedor.comprarProducto(monedaSeleccionada, Catalogo.SNICKERS);
                    } else if (y >= 390 && y <= 430) {
                        expendedor.comprarProducto(monedaSeleccionada, Catalogo.SUPER8);
                    }
                    monedaSeleccionada = null;
                    System.out.println("Compra efectuada");
                    mensajeEstado = "Compra efectuada Retire su producto.";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    mensajeEstado = e.getMessage();
                }
            } else if (y >= 190 && y <= 430) {
                System.out.println("Selecciona una moneda primero");
                mensajeEstado = "Debes seleccionar una moneda";
            }
        }
    }
}