/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.servicio;

import videogameturnos.modelo.Arma;
import videogameturnos.modelo.Jugador;
import videogameturnos.modelo.Personaje;
import videogameturnos.modelo.Raza;

/**
 *
 * @author Ben
 */
/**
 * Clase que maneja la lógica principal del juego, incluyendo la selección de personajes, combate y turnos.
 */
public class Juego {

    private Personaje personaje1;
    private Personaje personaje2;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public Personaje getPersonaje1() {
        return personaje1;
    }

    public Personaje getPersonaje2() {
        return personaje2;
    }

    /**
     * Método para iniciar el juego.
     * Este método selecciona los personajes, muestra sus detalles e inicia el combate.
     */
    public void iniciarJuego() {
        personaje1 = seleccionarPersonaje(jugador1);
        personaje2 = seleccionarPersonaje(jugador2);

        // Mostrar la información de los personajes seleccionados
        personaje1.mostrarInfo();
        personaje2.mostrarInfo();

        // Iniciar el combate
        combate();
    }

    /**
     * Método para seleccionar un personaje para un jugador.
     * Este método debería integrar la lógica para que el jugador elija su personaje.
     */
    private Personaje seleccionarPersonaje(Jugador jugador) {
        // Lógica de selección de personaje
        // Asegúrate de que el constructor de la clase Raza esté correctamente implementado
        Raza raza = new Raza("Humano", "Un ser humano común");  // Verifica que el constructor de Raza esté bien definido
        Arma arma = new Arma("Escopeta", "Físico", 1, 5, 10, "+2% daño");  // Verifica que el constructor de Arma esté bien definido

        // Retorna un nuevo personaje con los parámetros definidos
        return new Personaje("John", 100, 50, 50, raza, arma);
    }

    /**
     * Método para gestionar el combate entre los dos personajes.
     * Los turnos se alternan entre los jugadores hasta que uno de los personajes pierde toda su vida.
     */
    public void combate() {
        boolean turnoJugador1 = true;

        // El combate continúa mientras ambos personajes estén vivos
        while (personaje1.estaVivo() && personaje2.estaVivo()) {
            if (turnoJugador1) {
                System.out.println("Turno de " + personaje1.getNombre());
                realizarAccion(personaje1, personaje2);
            } else {
                System.out.println("Turno de " + personaje2.getNombre());
                realizarAccion(personaje2, personaje1);
            }

            turnoJugador1 = !turnoJugador1;  // Alternar entre jugadores
        }

        // Al final del combate, determinar el ganador
        if (personaje1.estaVivo()) {
            System.out.println(jugador1.getNombre() + " gana la partida!");
            jugador1.actualizarEstadisticas(true);
            jugador2.actualizarEstadisticas(false);
        } else {
            System.out.println(jugador2.getNombre() + " gana la partida!");
            jugador1.actualizarEstadisticas(false);
            jugador2.actualizarEstadisticas(true);
        }
    }

    /**
     * Realiza la acción del combate: ataque o sanación.
     */
    private void realizarAccion(Personaje atacante, Personaje defensor) {
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre());
        atacante.atacar(defensor);
    }

    /**
     * Muestra las estadísticas de ambos jugadores al final de la partida.
     */
    public void mostrarEstadisticas() {
        jugador1.mostrarEstadisticas();
        jugador2.mostrarEstadisticas();
    }
}
