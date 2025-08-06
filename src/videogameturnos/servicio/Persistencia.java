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

    private static final String URL = "jdbc:sqlserver://localhost;databaseName=VideojuegoCombate;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "112306";

    /**
     * Método para obtener una conexión a la base de datos.
     */
    public static Connection obtenerConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Método para insertar un nuevo jugador
    public static void insertarJugador(Jugador jugador) {
        String sql = "INSERT INTO jugador (nombre, partidas_ganadas, partidas_perdidas) VALUES (?, ?, ?)";
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, jugador.getNombre().trim()); // Insertar el nombre tal cual
            stmt.setInt(2, jugador.getPartidasGanadas());
            stmt.setInt(3, jugador.getPartidasPerdidas());

            stmt.executeUpdate();
            System.out.println("Jugador insertado: " + jugador.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //para verificar si un jugador ya exite en la base de datos
    public static boolean jugadorExiste(Jugador jugador) {
        String sql = "SELECT COUNT(*) FROM jugador WHERE nombre = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Establece el nombre del jugador a buscar
            stmt.setString(1, jugador.getNombre().trim()); // Se asegura de eliminar espacios extra
            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true; // El jugador existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // El jugador no existe
    }

    /**
     * Método para guardar un personaje en la base de datos.
     */
    public static void guardarPersonaje(Personaje personaje) {
        String sql = "INSERT INTO personaje (nombre, raza, fuerza, energia, vida_actual, id_arma) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setString(1, personaje.getNombre());
            stmt.setString(2, personaje.getRaza().getNombre());
            stmt.setInt(3, personaje.getFuerza());
            stmt.setInt(4, personaje.getEnergia());
            stmt.setInt(5, personaje.getVida());
            stmt.setInt(6, personaje.getArma().getId());
            
            stmt.executeUpdate();
            System.out.println("Personaje guardado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //metodo para que actualice las estadísticas de un jugador
  public static void actualizarEstadisticas(Jugador jugador) {
    String sql = "UPDATE jugador SET partidas_ganadas = ?, partidas_perdidas = ? WHERE nombre = ?";

    try (Connection conexion = obtenerConexion();  // Conexión a la base de datos
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        // Establece los valores de las estadísticas
        stmt.setInt(1, jugador.getPartidasGanadas());
        stmt.setInt(2, jugador.getPartidasPerdidas());
        stmt.setString(3, jugador.getNombre());

        // Ejecuta la actualización
        int filasAfectadas = stmt.executeUpdate();
        
        // Verifica si se actualizó alguna fila
        if (filasAfectadas > 0) {
            System.out.println("Estadisticas actualizadas para: " + jugador.getNombre());
        } else {
            System.out.println("No se encontro al jugador para actualizar.");
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Si hay un error, imprime el stack trace
    }
}
}