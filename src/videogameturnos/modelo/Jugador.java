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
    // Nombre del jugador
    private String nombre;
    // Número de partidas ganadas por el jugador
    private int partidasGanadas;
    // Número de partidas perdidas por el jugador
    private int partidasPerdidas;

    /**
     * Constructor para crear un nuevo jugador.
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    /**
     * Método para actualizar las estadísticas del jugador después de una partida.
     * Si el jugador gana, se incrementa el contador de partidas ganadas, de lo contrario se incrementa el contador de partidas perdidas.
     * @param gano Indica si el jugador ganó la partida (true) o la perdió (false).
     */
    public void actualizarEstadisticas(boolean gano) {
        if (gano) {
            this.partidasGanadas++;
        } else {
            this.partidasPerdidas++;
        }
    }

    
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

    
}
