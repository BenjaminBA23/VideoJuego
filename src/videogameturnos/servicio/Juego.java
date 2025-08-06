/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.servicio;

import java.util.Scanner;
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
     // Salto de línea para separar visualmente
    System.out.println("\n\nSeleccionando un personaje para: " + jugador1.getNombre());
    System.out.println("Seleccionando un personaje para: " + jugador2.getNombre());
    System.out.println("\n\n");

    // Selección de personajes
    personaje1 = seleccionarPersonaje(jugador1);
    personaje2 = seleccionarPersonaje(jugador2);

    // Mostrar información de los personajes elegidos con etiquetas y saltos de línea
    System.out.println("Personaje para: " + jugador1.getNombre());
    personaje1.mostrarInfo();
    System.out.println("\n");

    System.out.println("Personaje para: " + jugador2.getNombre());
    personaje2.mostrarInfo();
    System.out.println("\n");

    // Iniciar el combate
    combate();
    }

    /**
     * Método para seleccionar un personaje para un jugador.
     * Este método debería integrar la lógica para que el jugador elija su personaje.
     */
    private Personaje seleccionarPersonaje(Jugador jugador) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\n-----------------------------------");
    System.out.println("Elije una raza para " + jugador.getNombre() + ":");
    System.out.println("1. Humano");
    System.out.println("2. Elfo");
    System.out.println("3. Orco");
    System.out.println("4. Bestia");
    System.out.print("Opcion: ");
    int opcion = scanner.nextInt();
    scanner.nextLine(); // Limpiar buffer

    String nombrePersonaje;
    System.out.print("Por favor escribe como quieres que se llame tu personaje: ");
    nombrePersonaje = scanner.nextLine();

    Raza raza = null;
    Arma arma = null;
    int vida = 100, fuerza = 50, energia = 50; // Puedes ajustar los valores base según la raza

    switch (opcion) {
        case 1: // Humano
            raza = new Raza("Humano", "Solo puede usar armas de fuego.");
            System.out.println("Elige un arma: ");
            System.out.println("1. Escopeta");
            System.out.println("2. Rifle Francotirador");
            int armaHumano = scanner.nextInt();
            arma = (armaHumano == 1)
                ? new Arma("Escopeta", "Físico", 1, 5, 10, "+2% daño")
                : new Arma("Rifle Francotirador", "Físico", 2, 5, 10, ""); // Ajusta valores
            break;
        case 2: // Elfo
            raza = new Raza("Elfo", "Solo puede usar magia (báculo).");
            System.out.println("Elige tipo de magia:");
            System.out.println("1. Fuego");
            System.out.println("2. Tierra");
            System.out.println("3. Aire");
            System.out.println("4. Agua");
            int armaElfo = scanner.nextInt();
            switch (armaElfo) {
                case 1: arma = new Arma("Magia de Fuego", "Magia", 3, 5, 10, "+10% daño"); break;
                case 2: arma = new Arma("Magia de Tierra", "Magia", 4, 5, 10, "+2% daño"); break;
                case 3: arma = new Arma("Magia de Aire", "Magia", 5, 5, 12, ""); break;
                case 4: 
                    arma = new Arma("Magia de Agua", "Magia", 6, 5, 10, ""); 
                    vida = 115; // Elfo agua tiene más vida inicial
                    break;
            }
            break;
        case 3: // Orco
            raza = new Raza("Orco", "Solo puede usar hacha o martillo.");
            System.out.println("Elige un arma: ");
            System.out.println("1. Hacha");
            System.out.println("2. Martillo");
            int armaOrco = scanner.nextInt();
            arma = (armaOrco == 1)
                ? new Arma("Hacha", "Físico", 7, 5, 10, "Sangrado")
                : new Arma("Martillo", "Físico", 8, 5, 10, "");
            break;
        case 4: // Bestia
            raza = new Raza("Bestia", "Puede elegir entre puños o espada.");
            System.out.println("Elige un arma: ");
            System.out.println("1. Puños");
            System.out.println("2. Espada");
            int armaBestia = scanner.nextInt();
            arma = (armaBestia == 1)
                ? new Arma("Puños", "Físico", 9, 25, 25, "-10 vida atacante")
                : new Arma("Espada", "Físico", 10, 1, 10, "");
            break;
        default:
            System.out.println("Opcion invalida, se asigna Humano con Escopeta.");
            raza = new Raza("Humano", "Default");
            arma = new Arma("Escopeta", "Físico", 1, 5, 10, "+2% destruccion");
    }

    return new Personaje(nombrePersonaje, vida, fuerza, energia, raza, arma);
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
        jugador1.setPartidasGanadas(jugador1.getPartidasGanadas() + 1); // Incrementa victorias
        jugador2.setPartidasPerdidas(jugador2.getPartidasPerdidas() + 1); // Incrementa derrotas
    } else {
        System.out.println(jugador2.getNombre() + " gana la partida!");
        jugador1.setPartidasPerdidas(jugador1.getPartidasPerdidas() + 1); // Incrementa derrotas
        jugador2.setPartidasGanadas(jugador2.getPartidasGanadas() + 1); // Incrementa victorias
    }
    
    // Llamada para insertar o actualizar las estadísticas de ambos jugadores
    if (!Persistencia.jugadorExiste(jugador1)) {
        Persistencia.insertarJugador(jugador1);  // Inserta el jugador si no existe
    } else {
        Persistencia.actualizarEstadisticas(jugador1);  // Actualiza si ya existe
    }

    if (!Persistencia.jugadorExiste(jugador2)) {
        Persistencia.insertarJugador(jugador2);  // Inserta el jugador si no existe
    } else {
        Persistencia.actualizarEstadisticas(jugador2);  // Actualiza si ya existe
    }

    // Llamada para actualizar las estadísticas en la base de datos
    Persistencia.actualizarEstadisticas(jugador1); // Actualiza las estadísticas del jugador 1
    Persistencia.actualizarEstadisticas(jugador2); // Actualiza las estadísticas del jugador 2
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
    
    public void actualizarEstadisticas(Jugador ganador, Jugador perdedor) {
    // Actualizamos el número de victorias y derrotas
    ganador.setPartidasGanadas(ganador.getPartidasGanadas() + 1);
    perdedor.setPartidasPerdidas(perdedor.getPartidasPerdidas() + 1);

    // Ahora se guarda en la base de datos
    Persistencia.actualizarEstadisticas(ganador);
    Persistencia.actualizarEstadisticas(perdedor);
    }
}
