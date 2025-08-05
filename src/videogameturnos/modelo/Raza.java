/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.modelo;

/**
 *
 * @author pame
 */
public class Raza {
    // Nombre de la raza (Ej. Humano, Elfo, Orco, Bestia)
    private String nombre;
    // Descripción de las características y habilidades de la raza
    private String descripcion;

    /**
     * Constructor para crear una raza con su nombre y descripción.
     * @param nombre El nombre de la raza.
     * @param descripcion Una breve descripción de la raza.
     */
    public Raza(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Métodos Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
