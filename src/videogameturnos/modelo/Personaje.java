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

    // Método para realizar un ataque
    public void atacar(Personaje defensor) {
        // Calcular el daño con el arma
        int dano = this.arma.atacar();  // Asumiendo que Arma tiene un método atacar que devuelve el daño
        defensor.recibirDanio(dano);
        System.out.println(this.nombre + " ataca a " + defensor.getNombre() + " y le hace " + dano + " de daño.");
        System.out.println(defensor.getNombre() + " recibe " + dano + " de daño. Vida restante: " + defensor.getVida());
    }

    // Método para sanar al personaje
    public void sanar() {
        if (this.energia >= 10) { // Supongamos que necesita 10 de energía para sanar
            int sanacion = (int) (this.vida * 0.25);  // Sanación del 25% de la vida
            this.vida += sanacion;
            this.energia -= 10;  // Gasta 10 de energía por sanar
            System.out.println(this.nombre + " se ha sanado por " + sanacion + " puntos. Vida actual: " + this.vida);
        } else {
            System.out.println(this.nombre + " no tiene suficiente energía para sanar.");
        }
    }

    // Método para avanzar o retroceder en el combate (ejemplo de lógica adicional)
    public void moverse(String direccion) {
        if (direccion.equals("adelante")) {
            System.out.println(this.nombre + " avanza hacia el oponente.");
        } else if (direccion.equals("atras")) {
            System.out.println(this.nombre + " retrocede.");
        } else {
            System.out.println("Dirección no válida.");
        }
    }

    // Método para verificar si el personaje está vivo
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Método para imprimir información básica del personaje
    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Raza: " + this.raza.getNombre());
        System.out.println("Vida: " + this.vida);
        System.out.println("Fuerza: " + this.fuerza);
        System.out.println("Energía: " + this.energia);
        System.out.println("Arma: " + this.arma.getNombre());
    }
}
