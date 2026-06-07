package org.example.modelo;


public class Expendedor {
    //Depositos genéricos para cada tipo de producto
    private Deposito<Producto> depCoca;
    private Deposito<Producto> depSprite;
    private Deposito<Producto> depFanta;
    private Deposito<Producto> depSnickers;
    private Deposito<Producto> depSuper8;

    //Deposito genérico para las monedas de vuelto
    private Deposito<Moneda> monVuelto;

    /**
     * Constructor que llena los depósitos
     * @param numProductos cantidad inicial para cada producto.
     */
    public Expendedor(int numProductos) {
        this.depCoca = new Deposito<>();
        this.depFanta = new Deposito<>();
        this.depSprite = new Deposito<>();
        this.depSnickers = new Deposito<>();
        this.depSuper8 = new Deposito<>();
        this.monVuelto = new Deposito<>();

        //LLenado de los depósitos con numeros de serie únicos
        for (int i = 0; i < numProductos; i++) {
            depCoca.add(new CocaCola(100 + i));
            depSprite.add(new Sprite(200 + i));
            depFanta.add(new Fanta(300 + i));
            depSnickers.add(new Snickers(400 + i));
            depSuper8.add(new Super8(500 + i));
        }
    }

    /**
     * Intenta realizar la compra de un producto.
     * @param m Moneda entregada como paga.
     * @param cual tipo de producto del Catalogo(Enum).
     * @trhows PagoIncorrectoException si la moneda es null.
     * @trhows NoHayProductoException si el deposito está vacío o el ID es erróneo.
     * @trhows PagoInsuficienteException si el valor de la moneda es menor al precio.
     */
    public Producto comprarProducto(Moneda m, Catalogo cual)
            throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException {

        //Primero se valida si la moneda existe
        if (m == null) {
            throw new PagoIncorrectoException("Error: No se ha ingresado una moneda.");
        }

        //Luego se valida si el dinero alcanza comparando con el Catalogo
        if (m.getValor() < cual.getPrecio()) {
            monVuelto.add(m); //Se devuelve la misma moneda
            throw new PagoInsuficienteException("Error: Dinero insuficiente para " + cual.name());
        }

        //Se intenta extraer el producto del depósito correspondiente.
        Producto p = switch (cual) {
            case COCACOLA -> depCoca.get();
            case SPRITE -> depSprite.get();
            case FANTA -> depFanta.get();
            case SNICKERS -> depSnickers.get();
            case SUPER8 -> depSuper8.get();
        };

        //Se valida el Stock.
        if (p == null) {
            monVuelto.add(m); //Se devuelve la misma moneda.
            throw new NoHayProductoException("Error: No queda stock de " + cual.name());
        }

        //Y finalmente se genera el vuelto en monedas de $100.
        int vueltoTotal = m.getValor() - cual.getPrecio();
        while (vueltoTotal >= 100) {
            monVuelto.add(new Moneda100());
            vueltoTotal -= 100;
        }

        return p;
    }

    /**
     * Permite retirar el vuelto moneda por moneda.
     * @return Una Moneda de $100 o null si no queda más vuelto.
     */
    public Moneda getVuelto() {
        return monVuelto.get();
    }
}