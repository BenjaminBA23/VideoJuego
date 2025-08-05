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
 * Clase que representa a un jugador en el juego.
 * Un jugador tiene un nombre y un historial de partidas ganadas y perdidas.
 */

public class Jugador {
    private String nombre;
    private int partidasGanadas;
    private int partidasPerdidas;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    // Método para actualizar las estadísticas del jugador
    public void actualizarEstadisticas(boolean gano) {
        if (gano) {
            this.partidasGanadas++;
        } else {
            this.partidasPerdidas++;
        }
    }

    // Método para mostrar las estadísticas del jugador
    public void mostrarEstadisticas() {
        System.out.println("Jugador: " + this.nombre);
        System.out.println("Partidas ganadas: " + this.partidasGanadas);
        System.out.println("Partidas perdidas: " + this.partidasPerdidas);
    }
}
