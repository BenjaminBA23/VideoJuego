/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package videogameturnos.Main;

import java.util.Scanner;
import videogameturnos.modelo.Jugador;
import videogameturnos.modelo.Personaje;
import videogameturnos.servicio.Juego;
import videogameturnos.servicio.Persistencia;

/**
 *
 * @author Ben
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" VIDEOJUEGO DE BATALLA POR TURNOS ");

        // Pedir nombres de los jugadores
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        Jugador jugador1 = new Jugador(nombreJugador1);

        System.out.print("Ingrese el nombre del Jugador 2: ");
        String nombreJugador2 = scanner.nextLine();
        Jugador jugador2 = new Jugador(nombreJugador2);

        // Iniciar juego
        Juego juego = new Juego(jugador1, jugador2);
        juego.iniciarJuego();

        // Mostrar estadísticas al final
        juego.mostrarEstadisticas();

        // Guardar personajes en la base de datos (si se usaron personajes generados manualmente)
        Personaje p1 = juego.getPersonaje1();
        Personaje p2 = juego.getPersonaje2();

        if (p1 != null && p2 != null) {
            Persistencia.guardarPersonaje(p1);
            Persistencia.guardarPersonaje(p2);
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}
