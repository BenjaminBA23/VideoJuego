/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package videogameturnos.servicio;

/**
 *
 * @author pame
 */

import java.sql.*;
import videogameturnos.modelo.Jugador;
import videogameturnos.modelo.Personaje;

/**
 * Clase encargada de la persistencia de datos en la base de datos utilizando JDBC.
 */
public class Persistencia {
    private Connection conexion;

    /**
     * Conecta a la base de datos usando JDBC.
     */
    public void conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/VideojuegoCombate"; // Cambia según tu base de datos
        String usuario = "usuario"; // Cambia según tu base de datos
        String contrasena = "contrasena"; // Cambia según tu base de datos
        conexion = DriverManager.getConnection(url, usuario, contrasena);
    }

    /**
     * Guarda un jugador en la base de datos.
     * @param jugador El jugador a guardar.
     */
    public void guardarJugador(Jugador jugador) {
        String sql = "INSERT INTO jugador (nombre, partidas_ganadas, partidas_perdidas) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, jugador.getNombre());
            stmt.setInt(2, jugador.getPartidasGanadas());
            stmt.setInt(3, jugador.getPartidasPerdidas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda un personaje en la base de datos.
     * @param personaje El personaje a guardar.
     */
    public void guardarPersonaje(Personaje personaje) {
        String sql = "INSERT INTO personaje (nombre, raza, fuerza, energia, vida_actual, id_arma) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, personaje.getNombre());
            stmt.setString(2, personaje.getRaza());
            stmt.setInt(3, personaje.getFuerza());
            stmt.setInt(4, personaje.getEnergia());
            stmt.setInt(5, personaje.getVidaActual());
            stmt.setInt(6, personaje.getIdArma());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}