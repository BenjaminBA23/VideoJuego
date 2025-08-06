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
}