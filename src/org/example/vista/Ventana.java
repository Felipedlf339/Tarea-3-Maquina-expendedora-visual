package org.example.vista;
import javax.swing.JFrame;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Inicializa el contenedor gráfico exterior y alberga el panel principal.
 * Contiene el método main para iniciar la ejecución
 */
public class Ventana extends JFrame {

    /**
     * Constructor de la clase Ventana.
     * Configura el título, el funcionamiento del cierre, añade el PanelPrincipal
     * y centra la ventana en la pantalla
     */
    public Ventana() {
        super("Maquina Expendedora de Dulces y Bebidas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new PanelPrincipal());

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Método de entrada principal de la aplicación
     * Crea una instancia única de la Ventana para iniciar la interfaz gráfica
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        new Ventana();
    }
}