package org.example.modelo;

/**
 * Máquina expendedora. Gestiona depositos de productos y monedas,
 * además de procesar compras y entregas de productos y vuelto.
 */

public class Expendedor {
    //Depositos genéricos para cada tipo de producto
    private Deposito<Producto> depCoca;
    private Deposito<Producto> depSprite;
    private Deposito<Producto> depFanta;
    private Deposito<Producto> depSnickers;
    private Deposito<Producto> depSuper8;

    //Deposito genérico para las monedas de vuelto
    private Deposito<Moneda> monVuelto;

    //Deposito especial de capacidad 1
    private Deposito<Producto> depProductoComprado;

    //Monedas recibidas en compras exitosas
    private Deposito<Moneda> depMonedasRecibidas;

    private int x;
    private int y;

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
        this.depProductoComprado = new Deposito<>();
        this.depMonedasRecibidas = new Deposito<>();


        this.x = 0;
        this.y = 0;

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
     * Si la compra es exitosa, deja el producto en depProductoComprado y el vuelto en monVuelto.
     */
    public void comprarProducto(Moneda m, Catalogo cual)
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

        depMonedasRecibidas.add(m);
        depProductoComprado.add(p);


        //Vuelto en monedas de mayor denominación posible
        int vueltoTotal = m.getValor() - cual.getPrecio();
        while (vueltoTotal >= 1000) { monVuelto.add(new Moneda1000()); vueltoTotal -= 1000; }
        while (vueltoTotal >= 500)  { monVuelto.add(new Moneda500());  vueltoTotal -= 500;  }
        while (vueltoTotal >= 100)  { monVuelto.add(new Moneda100());  vueltoTotal -= 100;  }
    }

    //Retorna el producto realizado en la compra
    public Producto getProducto() {return depProductoComprado.get();}

    //Retorna una moneda de vuelto, o null si no queda.
    public Moneda getVuelto()  {return monVuelto.get();}

    //Rellena los depósitos que estén vacíos.
    public void rellenarDepositosVacios(int numProductos){
        if (depCoca.isEmpty()) for (int i = 0; i < numProductos; i++) {
            depCoca.add(new CocaCola(100 + i));
            }
        if (depSprite.isEmpty()) for (int i = 0; i < numProductos; i++) {
            depSprite.add(new Sprite(200 + i));
        }
        if (depFanta.isEmpty()) for (int i = 0; i < numProductos; i++) {
            depFanta.add(new Fanta(300 + i));
        }
        if (depSnickers.isEmpty()) for (int i = 0; i < numProductos; i++) {
            depSnickers.add(new Snickers(400 + i));
        }
        if (depSuper8.isEmpty()) for (int i = 0; i < numProductos; i++) {
            depSuper8.add(new Super8(500 + i));
        }

    }

    //Getters de depósitos para que el apartado de vista gráfica pueda dibujarlos.
    public Deposito<Producto> getDepCoca() {return depCoca;}
    public Deposito<Producto> getDepSprite() {return depSprite;}
    public Deposito<Producto> getDepFanta() {return depFanta;}
    public Deposito<Producto> getDepSnickers() {return depSnickers;}
    public Deposito<Producto> getDepSuper8() {return depSuper8;}
    public Deposito<Moneda> getMonVuelto() {return monVuelto;}
    public Deposito<Producto> getDepProductoComprado() {return depProductoComprado;}
    public Deposito<Moneda> getDepMonedasRecibidas() {return depMonedasRecibidas;}

    public void setXY(int x, int y) {this.x = x; this.y = y;}
    public int getX() {return x;}
    public int getY() {return y;}

}