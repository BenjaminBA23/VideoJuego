/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.modelo;

import java.util.Random;

/**
 *
 * @author pame
 */
/**
 * Clase que representa un arma en el juego.
 * Un arma tiene un nombre, un tipo (por ejemplo, hacha, espada, hechizo), y valores para el daño que puede causar.
 */
public class Arma {
    private String nombre;
    private String tipo;
    private int danoMinimo;
    private int danoMaximo;
    private String modificadores;
    private final int id;

    // Constructor actualizado
    public Arma(String nombre, String tipo, int id, int danoMinimo, int danoMaximo, String modificadores) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.danoMinimo = danoMinimo;
        this.danoMaximo = danoMaximo;
        this.modificadores = modificadores;
    }

    // Getters y Setters
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

    public String getModificadores() {
        return modificadores;
    }

    public void setModificadores(String modificadores) {
        this.modificadores = modificadores;
    }

    public int getId() {
        return id;
    }

    /**
     * Método para realizar un ataque con el arma.
     * Calcula un daño aleatorio dentro del rango de daño de este arma.
     * Si el arma tiene modificadores, aplica un porcentaje adicional de daño.
     */
    public int atacar() {
        Random random = new Random();
        int rango = danoMaximo - danoMinimo + 1;
        if (rango <= 0) {
            System.out.println("Error: El rango de daño es invalido para el arma " + nombre);
            return 0;  // Si el rango es inválido, no realiza el ataque
        }

        // Calcula el daño aleatorio dentro del rango de daño
        int dano = random.nextInt(rango) + danoMinimo;

        // Aplicar modificadores (Ejemplo: +2% de daño adicional)
        if (modificadores != null && modificadores.contains("%")) {
            try {
                int porcentaje = Integer.parseInt(modificadores.replaceAll("[^\\d]", ""));
                dano += (dano * porcentaje) / 100;  // Aumenta el daño con el modificador
            } catch (NumberFormatException e) {
                System.out.println("Error al interpretar el modificador: " + modificadores);
            }
        }

        return dano;
    }

    /**
     * Muestra la información del arma.
     */
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Daño: " + danoMinimo + " - " + danoMaximo);
        System.out.println("Modificadores: " + modificadores);
    }
}
