package org.infantaelena.modelo.dao;

import org.infantaelena.modelo.entidades.Pokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class PokemonDAObdd {
    // Nombre de la base de datos que vamos a usar
    static String databaseFileName = "pokeapi.db";

    public static void cargarBaseDeDatos() {
        // Establecemos la conexion a la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName)) {

            // Verificamos si la base de datos ya existe
            boolean existe = new File(databaseFileName).exists();

            if (!existe) {
                System.out.println("La base de datos no existe. Se creara una nueva... ");

                // Leemos el contenido del archivo create pokeapi.db y lo ejecutamos con un statement
                File fileCreate = new File("./create pokeapi.db");
                try (Scanner scc = new Scanner(fileCreate)) {
                    Statement statement = connection.createStatement();
                    while (scc.hasNextLine()) {
                        String line = scc.nextLine();
                        statement.execute(line);
                    }
                    statement.close();
                } catch (FileNotFoundException | SQLException e) {
                    System.out.println("Archivo create pokeapi.db no encontrado o error al ejecutar.");
                }

                // Leemos el contenido de insert pokeapi.db
                File fileInsert = new File("./insert pokeapi.db");
                try (Scanner sci = new Scanner(fileInsert)) {
                    Statement statement = connection.createStatement();
                    while (sci.hasNextLine()) {
                        String line = sci.nextLine();
                        statement.execute(line);
                    }
                    statement.close();
                } catch (FileNotFoundException | SQLException e) {
                    System.out.println("Archivo insert pokeapi.db no encontrado o error al ejecutar.");
                }

                System.out.println("La base de datos se ha cargado correctamente!");

            } else {
                System.out.println("La base de datos ya existe!");
            }

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}

