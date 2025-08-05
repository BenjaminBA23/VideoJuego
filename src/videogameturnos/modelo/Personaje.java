/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.modelo;

/**
 *
 * @author Ben
 */
/**
 * Clase base que representa a un personaje en el juego.
 * Los personajes pueden ser de diferentes razas, tener armas y habilidades especiales.
 */
public class Personaje {
    // Nombre del personaje
    protected String nombre;
    // Puntos de vida actuales del personaje
    protected int vida;
    // Energía disponible para el personaje (determina cuántas acciones puede realizar)
    protected int energia;
    // Arma que el personaje usa en combate
    protected Arma arma;

    /**
     * Constructor para crear un nuevo personaje con su nombre y arma.
     * @param nombre El nombre del personaje.
     * @param arma El arma que el personaje utilizará en combate.
     */
    public Personaje(String nombre, Arma arma) {
        this.nombre = nombre;
        this.arma = arma;
        this.energia = 100; // valor predeterminado
        this.vida = 100;    // valor predeterminado
    }

    /**
     * Método para que el personaje reciba daño durante el combate.
     * @param danio La cantidad de daño que recibirá el personaje.
     */
    public void recibirDanio(int danio) {
        this.vida -= danio;
    }

    /**
     * Método para que el personaje se sanee, recuperando puntos de vida.
     * @param cantidad La cantidad de vida que se recupera.
     */
    public void sanar(int cantidad) {
        this.vida += cantidad;
    }

    // Métodos Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }
    
}
