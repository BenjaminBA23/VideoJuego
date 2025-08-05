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
    private String tipo;  // Tipo de arma: Físico, Magia, etc.
    private int danoMinimo;  // Daño mínimo que puede hacer el arma
    private int danoMaximo;  // Daño máximo que puede hacer el arma
    private String modificadores;  // Modificadores especiales (ejemplo: "+2% daño")
    private final int id;

    // Constructor
    public Arma(String nombre, String tipo, int id, int danoMinimo, String modificadores) {
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

    
    
    // Método para realizar un ataque con el arma
    public int atacar() {
        // Calcular el daño aleatorio entre el daño mínimo y máximo
        Random random = new Random();
        int dano = random.nextInt(danoMaximo - danoMinimo + 1) + danoMinimo;

        // Aplicar modificadores (Ejemplo: +2% de daño adicional)
        if (modificadores != null && modificadores.contains("%")) {
            int porcentaje = Integer.parseInt(modificadores.replace("%", ""));
            dano += (dano * porcentaje) / 100;  // Aumentar el daño en base al modificador
        }

        return dano;
    }

    // Método para mostrar la información del arma
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Daño: " + danoMinimo + " - " + danoMaximo);
        System.out.println("Modificadores: " + modificadores);
    }
}
