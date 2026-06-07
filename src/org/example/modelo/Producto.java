package org.example.modelo;

/**
 * Clase abstracta que representa un producto genérico en el sistema.
 * Define los atributos compartidos por todos los productos:
 * número de serie único y coordenadas (x, y) para su representación gráfica.
 */
public abstract class Producto {

    /** Número de serie para identificar al producto. */
    private int serie;

    /** Coordenada X del producto dentro de su depósito en la ventana gráfica. */
    private int x;

    /** Coordenada Y del producto dentro de su depósito en la ventana gráfica. */
    private int y;

    /**
     * Constructor que inicializa el producto con su número de serie.
     * @param serie número de serie del producto.
     */
    public Producto(int serie) {
        this.serie = serie;
        this.x = 0;
        this.y = 0;
    }

    /**
     * Metodo abstracto que cada subclase implementa según su tipo.
     * @return cadena de texto que indica el nombre del producto consumido.
     */
    public abstract String consumir();

    /**
     * Retorna el número de serie del producto.
     * @return número de serie.
     */
    public int getSerie() {return serie;}

    /**
     * Establece la posición gráfica del producto dentro de su depósito.
     * @param x coordenada horizontal en píxeles.
     * @param y coordenada vertical en píxeles.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna la coordenada X del producto.
     * @return posición horizontal en píxeles.
     */
    public int getX() {return x;}

    /**
     * Retorna la coordenada Y del producto.
     * @return posición vertical en píxeles.
     */
    public int getY() {return y;}

}