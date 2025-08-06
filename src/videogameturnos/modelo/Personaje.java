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
    private String nombre;
    private int vida;
    private int fuerza;
    private int energia;
    private Raza raza;  // Representa la raza del personaje (Humano, Elfo, Orco, Bestia)
    private Arma arma;  // El arma que usa el personaje

    // Constructor
    public Personaje(String nombre, int vida, int fuerza, int energia, Raza raza, Arma arma) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.energia = energia;
        this.raza = raza;
        this.arma = arma;
    }

    // Getters y Setters
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

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    // Método para recibir daño
 public void recibirDanio(int danio) {
        this.vida -= danio;
    }

    /**
     * Método para realizar un ataque a otro personaje.
     */
    public void atacar(Personaje defensor) {
        int dano = this.arma.atacar();  // Usamos el método atacar del arma
        defensor.recibirDanio(dano);
        System.out.println(this.nombre + " ataca a " + defensor.getNombre() + " y le hace " + dano + " de destruccion.");
    }

    /**
     * Método para sanar al personaje.
     */
    public void sanar() {
        if (this.energia >= 10) {
            int sanacion = (int) (this.vida * 0.25);  // Sanación del 25% de la vida
            this.vida += sanacion;
            this.energia -= 10;  // Gasta 10 de energía por sanar
            System.out.println(this.nombre + " se ha sanado por " + sanacion + " puntos. Vida actual: " + this.vida);
        } else {
            System.out.println(this.nombre + " no tiene suficiente energia para sanar.");
        }
    }
    
    /**
     * Método para mostrar la información básica del personaje.
     */
    public void mostrarInfo() {
         System.out.println("Nombre: " + this.nombre);
        System.out.println("Raza: " + this.raza.getNombre());
        System.out.println("Vida: " + this.vida);
        System.out.println("Fuerza: " + this.fuerza);
        System.out.println("Energia: " + this.energia);
        System.out.println("Arma: " + this.arma.getNombre());
        System.out.println(""); // Salto de línea extra al final
    }

    /**
     * Verifica si el personaje está vivo.
     * @return true si el personaje está vivo (vida > 0).
     */
    public boolean estaVivo() {
        return this.vida > 0;
    }
}
