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


    // Método para iniciar el juego
    public void iniciarJuego() {
        // Se asume que se crean personajes a partir de la selección del jugador y de la base de datos
        personaje1 = seleccionarPersonaje(jugador1);
        personaje2 = seleccionarPersonaje(jugador2);
        
        // Mostrar información de los personajes
        personaje1.mostrarInfo();
        personaje2.mostrarInfo();

        // Iniciar el combate
        combate();
    }

    // Método para seleccionar un personaje
    private Personaje seleccionarPersonaje(Jugador jugador) {
        // Aquí se puede implementar la lógica de selección de personaje por parte del jugador
        // Se puede también recuperar un personaje previamente creado de la base de datos
        System.out.println("Seleccionando personaje para: " + jugador.getNombre());
        
        // Ejemplo de creación de personajes (deberías integrar la selección del jugador)
        Raza raza = new Raza("Humano", "Un ser humano común");
        Arma arma = new Arma("Escopeta", "Físico", 1, 5, "+2% daño");
        Personaje personaje = new Personaje("John", 100, 50, 50, raza, arma);
        
        return personaje;
    }

    // Método para gestionar el combate entre los dos personajes
    public void combate() {
        boolean turnoJugador1 = true;

        // El combate continua mientras ambos personajes estén vivos
        while (personaje1.estaVivo() && personaje2.estaVivo()) {
            if (turnoJugador1) {
                System.out.println("Turno de " + personaje1.getNombre());
                realizarAccion(personaje1, personaje2);
            } else {
                System.out.println("Turno de " + personaje2.getNombre());
                realizarAccion(personaje2, personaje1);
            }
            
            turnoJugador1 = !turnoJugador1;  // Alternar turno
        }

        // Determinar el ganador
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

    // Método para realizar una acción durante el combate
    private void realizarAccion(Personaje atacante, Personaje defensor) {
        // El atacante elige qué acción realizar: atacar, sanar, moverse, etc.
        System.out.println(atacante.getNombre() + " decide atacar a " + defensor.getNombre());
        atacante.atacar(defensor);

        // Aquí también se podrían agregar opciones como sanar o moverse
        // Por ejemplo: atacante.sanar();
    }

    // Método para mostrar las estadísticas de ambos jugadores
    public void mostrarEstadisticas() {
        System.out.println("Estadísticas de " + jugador1.getNombre() + ":");
        System.out.println("Partidas ganadas: " + jugador1.getPartidasGanadas() + " | Partidas perdidas: " + jugador1.getPartidasPerdidas());
        System.out.println("Estadísticas de " + jugador2.getNombre() + ":");
        System.out.println("Partidas ganadas: " + jugador2.getPartidasGanadas() + " | Partidas perdidas: " + jugador2.getPartidasPerdidas());
    }
}
