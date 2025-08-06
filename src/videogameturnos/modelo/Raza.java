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
    private String nombre;       // Nombre de la raza (Ej: Humano, Elfo, Orco, Bestia)
    private String descripcion;  // Descripción de la raza (por ejemplo, características, habilidades)

    // Constructor
    public Raza(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
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

    // Método para mostrar la información de la raza
    public void mostrarInfo() {
        System.out.println("Raza: " + this.nombre);
        System.out.println("Descripcion: " + this.descripcion);
    }
}
