package org.infantaelena.modelo.dao;

import org.infantaelena.modelo.entidades.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class PokemonDAObdd {
    // Nombre de la base de datos que vamos a usar-
    ////TODO: quitarle los comentarios del argumento String databaseFileName que le dará el método seleccionarBDD en Controlador.
    static String databaseFileName = "pokeapi.db";

    public static void cargarBaseDeDatos(String databaseFileName) {
        // Establecemos la conexión a la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {

            // Verificamos si la base de datos ya existe
            boolean existe = new File(databaseFileName).exists();

            if (!existe) {
                System.out.println("La base de datos no existe. Se creará una nueva... ");

                // Creamos la tabla Pokemon
                String createTableQuery =
                        "CREATE TABLE Pokemon (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nombre STRING," +
                        "tipo ENUM," +
                        "vida INTEGER," +
                        "ataque INTEGER," +
                        "defensa INTEGER" +
                        ")";
                try (Statement statement = connection.createStatement()) {
                    statement.execute(createTableQuery);
                } catch (SQLException e) {
                    System.out.println("Error al crear la tabla Pokemon.");
                    return;
                }

                // Insertamos los datos de ejemplo
                String insertQuery = "INSERT INTO Pokemon (nombre, tipo, vida, ataque, defensa) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Insertar Pokemon 1
                    preparedStatement.setString(1, "Bulbasaur");
                    preparedStatement.setString(2, "Planta");
                    preparedStatement.setInt(3, 45);
                    preparedStatement.setInt(4, 49);
                    preparedStatement.setInt(5, 49);
                    preparedStatement.executeUpdate();

                    // Insertar Pokemon 2
                    preparedStatement.setString(1, "Charmander");
                    preparedStatement.setString(2, "Fuego");
                    preparedStatement.setInt(3, 39);
                    preparedStatement.setInt(4, 52);
                    preparedStatement.setInt(5, 43);
                    preparedStatement.executeUpdate();

                    // Insertar Pokemon 3
                    preparedStatement.setString(1, "Squirtle");
                    preparedStatement.setString(2, "Agua");
                    preparedStatement.setInt(3, 44);
                    preparedStatement.setInt(4, 48);
                    preparedStatement.setInt(5, 65);
                    preparedStatement.executeUpdate();

                    System.out.println("Los datos se han cargado correctamente en la base de datos!");

                } catch (SQLException e) {
                    System.out.println("Error al insertar los datos.");
                }

            } else {
                System.out.println("La base de datos ya existe!");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}


