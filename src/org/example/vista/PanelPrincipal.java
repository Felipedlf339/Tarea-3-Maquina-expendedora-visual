package org.example.vista;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que representa el panel principal de la aplicación.
 * Coordina el dibujo manual de las vistas del comprador y del expendedor
 * y captura los clics del mouse para poder actualizar interfaz.
 */
public class PanelPrincipal extends JPanel implements MouseListener {

    private PanelComprador com;
    private PanelExpendedor exp;

    /**
     * Constructor de la clase PanelPrincipal.
     * Desactiva el administrador de diseño para poder posicionar todo manualmente,
     * e inicializa los componentes y registra el MouseListener.
     */
    public PanelPrincipal() {
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(1200, 800));

        this.exp = new PanelExpendedor();
        this.com = new PanelComprador();

        this.addMouseListener(this);
    }

    /**
     * Sobrescribe el método de dibujo para renderizar el fondo y delegar
     * pintado hacia las vistas del comprador y del expendedor.
     * @param g El contexto gráfico utilizado para pintar.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        com.paintComponent(g);
        exp.paintComponent(g);
    }

    /**
     * Captura el clic del mouse, obtiene sus coordenadas y revisa qué
     * acción corresponde ejecutar en base a eso.
     * @param e El evento de mouse capturado.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // com.verificarClic(x, y);
        // exp.verificarClic(x, y);

        this.repaint(); // Redibuja toda la pantalla tras cada acción
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}