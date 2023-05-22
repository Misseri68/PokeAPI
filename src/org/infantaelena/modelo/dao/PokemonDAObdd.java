package org.infantaelena.modelo.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PokemonDAObdd {
    public static void cargarBaseDeDatos() {
        String databaseFileName="pokeapi.db";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {
            System.out.println("Conexión establecida a la base de datos: " + databaseFileName);

            // Crear la tabla Pokemon
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Pokemon (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT," +
                    "tipo TEXT," +
                    "vida INTEGER," +
                    "ataque INTEGER," +
                    "defensa INTEGER" +
                    ")";
            try (Statement statement = connection.createStatement()) {
                statement.execute(createTableQuery);
                System.out.println("Tabla Pokemon creada o ya existente.");
            } catch (SQLException e) {
                System.out.println("Error al crear la tabla Pokemon: " + e.getMessage());
                return;
            }

            // Insertar los datos de ejemplo
            String insertQuery = "INSERT INTO Pokemon (nombre, tipo, vida, ataque, defensa) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            /*    // Insertar Pokemon 1
                preparedStatement.setString(1, "Bulbasaur");
                preparedStatement.setString(2, "PLANTA");
                preparedStatement.setInt(3, 45);
                preparedStatement.setInt(4, 49);
                preparedStatement.setInt(5, 49);

                preparedStatement.executeUpdate();

                // Insertar Pokemon 2
                preparedStatement.setString(1, "Charmander");
                preparedStatement.setString(2, "FUEGO");
                preparedStatement.setInt(3, 39);
                preparedStatement.setInt(4, 52);
                preparedStatement.setInt(5, 43);
                preparedStatement.executeUpdate();

                // Insertar Pokemon 3
                preparedStatement.setString(1, "Squirtle");
                preparedStatement.setString(2, "AGUA");
                preparedStatement.setInt(3, 44);
                preparedStatement.setInt(4, 48);
                preparedStatement.setInt(5, 65);
                preparedStatement.executeUpdate();
*/
                System.out.println("Los datos se han cargado correctamente en la base de datos!");

            } catch (SQLException e) {
                System.out.println("Error al insertar los datos: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        PokemonDAObdd.cargarBaseDeDatos();
    }
}