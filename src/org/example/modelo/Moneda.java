package org.example.modelo;

/**
 * Clase abstracta que representa una moneda en el sistema
 * Las monedas son polimórficas e implementan Comparable para permitir su ordenamiento
 * Cada moneda se identifica por su valor y su hashCode.
 */

public abstract class Moneda implements Comparable<Moneda> {
    public Moneda() {}

    public abstract int getValor();

    @Override
    public int compareTo(Moneda otra) {
        return Integer.compare(this.getValor(), otra.getValor());
    }

    @Override
    public String toString() {
        return "Moneda de $" + this.getValor() + " (Serie: " + this.hashCode() + ")";
    }
}