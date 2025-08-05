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
    private Jugador jugador1;
    private Jugador jugador2;
    private Personaje personaje1;
    private Personaje personaje2;

    /**
     * Método para iniciar el juego, solicitando el nombre de los jugadores y la selección de personajes.
     */
    public void iniciarJuego() {
        System.out.println("Bienvenidos al videojuego de combate por turnos.");

        // Solicitar nombres de los jugadores
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombreJugador1 = System.console().readLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombreJugador2 = System.console().readLine();

        // Crear jugadores
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);

        // Selección de personajes para ambos jugadores
        personaje1 = seleccionarPersonaje(jugador1);
        personaje2 = seleccionarPersonaje(jugador2);

        // Comienza el combate
        combate();
    }

    /**
     * Método que maneja el combate entre dos jugadores, alternando turnos hasta que uno de ellos gane.
     */
    public void combate() {
        boolean turnoJugador1 = true;
        while (personaje1.vida > 0 && personaje2.vida > 0) {
            if (turnoJugador1) {
                realizarAccion(personaje1, personaje2);
            } else {
                realizarAccion(personaje2, personaje1);
            }
            turnoJugador1 = !turnoJugador1;
        }

        // Determinar el ganador
        if (personaje1.vida <= 0) {
            System.out.println(jugador2.getNombre() + " gana la partida!");
            jugador2.actualizarEstadisticas(true);
            jugador1.actualizarEstadisticas(false);
        } else {
            System.out.println(jugador1.getNombre() + " gana la partida!");
            jugador1.actualizarEstadisticas(true);
            jugador2.actualizarEstadisticas(false);
        }
    }

    /**
     * Método que permite seleccionar un personaje para un jugador.
     * @param jugador El jugador que va a seleccionar el personaje.
     * @return El personaje seleccionado.
     */
    private Personaje seleccionarPersonaje(Jugador jugador) {
        // Mostrar opciones y leer entrada del jugador
        System.out.println("Selecciona la raza para " + jugador.getNombre() + ":");
        System.out.println("1. Humano");
        System.out.println("2. Elfo");
        System.out.println("3. Orco");
        System.out.println("4. Bestia");

        int seleccion = Integer.parseInt(System.console().readLine());

        // Crear un personaje basado en la raza seleccionada
        Raza raza = null;
        Arma arma = null;

        switch (seleccion) {
            case 1:
                raza = new Raza("Humano", "Habilidad en armas de fuego.");
                arma = new Arma("Escopeta", "Fuego", 1, 5);
                break;
            case 2:
                raza = new Raza("Elfo", "Habilidad en magia.");
                arma = new Arma("Báculo", "Magia", 1, 5);
                break;
            case 3:
                raza = new Raza("Orco", "Habilidad en combate cuerpo a cuerpo.");
                arma = new Arma("Hacha", "Cuerpo a cuerpo", 1, 5);
                break;
            case 4:
                raza = new Raza("Bestia", "Habilidad en ataques físicos.");
                arma = new Arma("Puños", "Cuerpo a cuerpo", 1, 10);
                break;
            default:
                System.out.println("Selección inválida. Se asignará Humano por defecto.");
                raza = new Raza("Humano", "Habilidad en armas de fuego.");
                arma = new Arma("Escopeta", "Fuego", 1, 5);
                break;
        }

        return new Personaje(jugador.getNombre(), arma);
    }

    /**
     * Método que permite realizar una acción en el combate (atacar, defender, sanar, etc.)
     * @param atacante El personaje que va a realizar la acción.
     * @param defensor El personaje que será atacado.
     */
    private void realizarAccion(Personaje atacante, Personaje defensor) {
        // Realizar un ataque simple
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre());
        int dano = atacante.arma.atacar();
        defensor.recibirDanio(dano);
        System.out.println(defensor.getNombre() + " recibe " + dano + " de daño. Vida restante: " + defensor.vida);
    }
}
