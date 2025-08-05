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
import videogameturnos.modelo.Arma;
import videogameturnos.modelo.Personaje;
import videogameturnos.modelo.Raza;

/**
 * Clase encargada de la persistencia de datos en la base de datos utilizando JDBC.
 */
public class Persistencia {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=VideojuegoCombate;encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";  // Cambia 'usuario' por el nombre de usuario de tu base de datos
    private static final String PASSWORD = "112306";  // Cambia 'contraseña' por la contraseña de tu base de datos

    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para guardar un personaje en la base de datos
    public static void guardarPersonaje(Personaje personaje) {
        String sql = "INSERT INTO personaje (nombre, raza, fuerza, energia, vida_actual, id_arma) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setString(1, personaje.getNombre());
            stmt.setString(2, personaje.getRaza().getNombre()); // Suponiendo que Raza tiene un nombre
            stmt.setInt(3, personaje.getFuerza());
            stmt.setInt(4, personaje.getEnergia());
            stmt.setInt(5, personaje.getVida());
            stmt.setInt(6, personaje.getArma().getId());  // Suponiendo que Arma tiene un método getId() que devuelve el ID del arma
            
            stmt.executeUpdate();
            System.out.println("Personaje " + personaje.getNombre() + " guardado en la base de datos.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para recuperar un personaje por su nombre
    public static Personaje obtenerPersonajePorNombre(String nombre) {
        String sql = "SELECT * FROM personaje WHERE nombre = ?";
        Personaje personaje = null;
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String personajeNombre = rs.getString("nombre");
                String razaNombre = rs.getString("raza");
                int fuerza = rs.getInt("fuerza");
                int energia = rs.getInt("energia");
                int vida = rs.getInt("vida_actual");
                int idArma = rs.getInt("id_arma");

                // Crear objetos de Raza y Arma (esto depende de las implementaciones de esas clases)
                Raza raza = obtenerRazaPorNombre(razaNombre); // Método que obtendría la Raza desde la base de datos
                Arma arma = obtenerArmaPorId(idArma); // Método que obtendría el Arma desde la base de datos

                personaje = new Personaje(personajeNombre, vida, fuerza, energia, raza, arma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return personaje;
    }

    // Método para actualizar las estadísticas de un jugador
    public static void actualizarEstadisticasJugador(int idJugador, int partidasGanadas, int partidasPerdidas) {
        String sql = "UPDATE jugador SET partidas_ganadas = ?, partidas_perdidas = ? WHERE id = ?";
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setInt(1, partidasGanadas);
            stmt.setInt(2, partidasPerdidas);
            stmt.setInt(3, idJugador);
            
            stmt.executeUpdate();
            System.out.println("Estadísticas del jugador actualizadas.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener una raza por su nombre
    private static Raza obtenerRazaPorNombre(String nombre) {
        String sql = "SELECT * FROM raza WHERE nombre = ?";
        Raza raza = null;
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String razaNombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                raza = new Raza(razaNombre, descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return raza;
    }

    // Método para obtener un arma por su ID
    private static Arma obtenerArmaPorId(int id) {
        String sql = "SELECT * FROM arma WHERE id = ?";
        Arma arma = null;
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
             
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nombreArma = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int danoMinimo = rs.getInt("dano_minimo");
                int danoMaximo = rs.getInt("dano_maximo");
                String modificadores = rs.getString("modificadores");
                
                arma = new Arma(nombreArma, tipo, danoMinimo, danoMaximo, modificadores);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return arma;
    }
}