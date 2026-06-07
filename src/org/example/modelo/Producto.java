package org.example.modelo;

/**
 * Clase abstracta que representa un producto génerico.
 * Define los atributos que deben compartir.
 */
public abstract class Producto {
    /**
     * Número de serie para identificar al producto;
     */
    private int serie;

    /**
     * Constructor que inicializa el producto con su número de serie.
     * @param serie número de serie del producto.
     */
    public Producto(int serie) {
        this.serie = serie;
    }

    /**
     * Método abstracto que cada subclase debe implementar según su sabor.
     * @return una cadena de texto que indica el sabor del producto consumido.
     */
    public abstract String consumir();

    /**
     * Se obtiene el número de serie del producto.
     * @return el número de serie del producto.
     */
    public int getSerie() {
        return serie;
    }


}
