package org.example.modelo;

/**
 * Enumeracion que representa el Catálogo de productos disponibles en el expendedor.
 * Cada valor posee un indentificador único y el precio del producto.
 */

public enum Catalogo {
    /** Bebida CocaCola, precio $1000 **/
    COCACOLA(1, 1000),
    /** Bebida Sprite, precio $1000 **/
    SPRITE(2, 1000),
    /** Bebida Fanta, precio $1000 **/
    FANTA(3, 1000),
    /** Dulce Snickers, precio $800 **/
    SNICKERS(4, 800),
    /** Dulce Super8, precio $500 **/
    SUPER8(5, 500);

    private final int id;
    private final int precio;

    /**
     *Constructor del enum con id y precio.
     * @param id
     * @param precio
     */

    Catalogo(int id, int precio){
        this.id = id;
        this.precio = precio;
    }

    /**
     * Retorna el precio del producto.
     * @return precio en pesos.
     */
    public int getPrecio(){return precio;}

    /**
     * @return id del producto.
     */
    public int getId(){return id;}
}

