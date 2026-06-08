package org.example.modelo;

/**
 * Clase que actúa como un comprador.
 * Compra, recibe el vuelto y consume el producto.
 */
public class Comprador {
    private String sabor;
    private int totalVuelto;

    /**
     * Constructor del Comprador que realiza la compra del producto.
     * @param moneda Moneda con la que se hace el pago.
     * @param cual Que producto del catálogo se quiere comprar.
     * @param expendedor Referencia al expendedor donde se realiza la compra.
     * @throws PagoIncorrectoException Si la moneda es null.
     * @throws NoHayProductoException  Si no se encuentra disponible el producto.
     * @throws PagoInsuficienteException Si el valor de la moneda no es suficiente para completar el pago.
     */
    public Comprador(Moneda moneda, Catalogo cual, Expendedor expendedor)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        this.sabor = null;
        this.totalVuelto = 0;

        // Intenta comprar el producto del expendedor.
        expendedor.comprarProducto(moneda, cual);
        Producto producto = expendedor.getProducto();
        // Se consume el producto y se guarda su sabor en una cadena de texto.
        this.sabor = producto.consumir();

        // Saca las monedas del vuelto una a una y las almacena hasta no quedar ninguna.
        Moneda vuelto = expendedor.getVuelto();
        while (vuelto != null) {
            this.totalVuelto += vuelto.getValor();
            vuelto = expendedor.getVuelto();
        }
    }

    /**
     * Para obtener el nombre del producto consumido.
     * @return retorna el sabor (nombre) del producto consumido.
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * Para obtener el total del vuelto recibido
     * @return el total del vuelto en un entero.
     */
    public int getTotalVuelto() {
        return totalVuelto;
    }
}