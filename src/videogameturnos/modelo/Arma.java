/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.modelo;

/**
 *
 * @author pame
 */
/**
 * Clase que representa un arma en el juego.
 * Un arma tiene un nombre, un tipo (por ejemplo, hacha, espada, hechizo), y valores para el daño que puede causar.
 */
public class Arma {
    // Nombre del arma (Ej. Escopeta, Hacha, Báculo)
    private String nombre;
    // Tipo del arma (Ej. Arma de fuego, Hechizo)
    private String tipo;
    // Daño mínimo que puede causar el arma
    private int danoMinimo;
    // Daño máximo que puede causar el arma
    private int danoMaximo;

    /**
     * Constructor para crear un arma con su nombre, tipo, y valores de daño.
     * @param nombre El nombre del arma.
     * @param tipo El tipo del arma (Ej. Magia, Arma de fuego).
     * @param danoMinimo El daño mínimo que el arma puede causar.
     * @param danoMaximo El daño máximo que el arma puede causar.
     */
    public Arma(String nombre, String tipo, int danoMinimo, int danoMaximo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.danoMinimo = danoMinimo;
        this.danoMaximo = danoMaximo;
    }

    /**
     * Método para realizar un ataque con el arma.
     * El daño es aleatorio entre el daño mínimo y máximo.
     * @return El daño calculado aleatoriamente.
     */
    public int atacar() {
        return (int) (Math.random() * (danoMaximo - danoMinimo + 1)) + danoMinimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanoMinimo() {
        return danoMinimo;
    }

    public void setDanoMinimo(int danoMinimo) {
        this.danoMinimo = danoMinimo;
    }

    public int getDanoMaximo() {
        return danoMaximo;
    }

    public void setDanoMaximo(int danoMaximo) {
        this.danoMaximo = danoMaximo;
    }

    
}
