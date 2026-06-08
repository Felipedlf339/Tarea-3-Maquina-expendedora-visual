package org.example.modelo;

/**
 * Clase abstracta que representa una moneda en el sistema.
 * Las monedas son polimórficas e implementan Comparable para permitir su ordenamiento.
 * Cada moneda tiene un número de serie único generado automáticamente,
 * y coordenadas (x, y) para su representación gráfica.
 */
public abstract class Moneda implements Comparable<Moneda> {

    //Contador estático para generar números de serie únicos entre todas las monedas.
    private static int contadorSerie = 1;

    // Número de serie único de esta moneda.
    private int serie;

    // Coordenada X e Y de la moneda dentro de su depósito en la ventana gráfica.
    private int x;
    private int y;

    /**
     * Constructor que asigna automáticamente un número de serie único.
     */
    public Moneda() {
        this.serie = contadorSerie++;
        this.x = 0;
        this.y = 0;
    }

    /**
     * Retorna el valor monetario de la moneda.
     * @return valor en pesos de la moneda.
     */
    public abstract int getValor();

    /**
     * Retorna el número de serie único de esta moneda.
     * @return número de serie.
     */
    public int getSerie() {
        return serie;
    }

    /**
     * Establece la posición gráfica de la moneda dentro de su depósito.
     * @param x coordenada horizontal en píxeles.
     * @param y coordenada vertical en píxeles.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retorna la coordenada X de la moneda.
     * @return posición horizontal en píxeles.
     */
    public int getX() {return x;}

    /**
     * Retorna la coordenada Y de la moneda.
     * @return posición vertical en píxeles.
     */
    public int getY() {return y;}

    /**
     * Compara esta moneda con otra según su valor, para permitir ordenamiento.
     * @param otra la moneda con la que se compara.
     * @return negativo si esta vale menos, 0 si son iguales, positivo si vale más.
     */
    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    /**
     * Representación en texto de la moneda con su valor y número de serie.
     * @return cadena con valor y serie de la moneda.
     */
    @Override
    public String toString() {
        return "Moneda de $" + this.getValor() + " (Serie: " + this.serie + ")";
    }
}