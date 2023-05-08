# pokeapi

## Objetivos

1 Crear y utilizar Excepciones personalizadas
2 Utilizar listas para almacenar y procesar información. 
3 Almacenar y recuperar datos y objetos de forma definitiva utilizando ficheros.
4 Construir y controlar los eventos producidos en aplicaciones con interfaz gráfica utilizando el modelo vista controlador.
5 Gestionar información almacenada en bases de datos relacionales manteniendo la integridad y la consistencia de los datos

## Enunciado

En esta práctica desarrollaremos una interfaz para gestionar operaciones CRUD (Crear, Leer, Actualizar y Borrar) para un API de Pokemons.

El objetivo es que el estudiante aprenda a crear y utilizar excepciones personalizadas, utilizar listas para almacenar y procesar información, almacenar y recuperar datos y objetos de forma definitiva utilizando ficheros, controlar eventos en aplicaciones con interfaz gráfica y entender el modelo vista controlador. Además, se espera que el estudiante aprenda a gestionar información almacenada en bases de datos relacionales, manteniendo la integridad y consistencia de los datos. En resumen, esta práctica proporcionará una experiencia completa de desarrollo de software desde el diseño hasta la implementación y mantenimiento de una aplicación con interfaz gráfica y gestión de bases de datos relacionales.

## Backlog
- Como usuario, quiero poder ver una lista de todos los Pokemons en el API para poder buscarlos y seleccionarlos.
- Como usuario, quiero poder crear nuevos Pokemons en el API ingresando su nombre, tipo y estadísticas para poder tener más opciones en mi lista.
- Como usuario, quiero poder actualizar los datos de un Pokemon existente en el API para corregir errores o actualizar sus estadísticas.
- Como usuario, quiero poder borrar un Pokemon existente en el API para eliminarlo de mi lista.
- Como usuario, quiero recibir una notificación de error clara si intento crear un Pokemon con un nombre que ya existe para no tener duplicados.
- Como usuario, quiero poder filtrar la lista de Pokemons por tipo para poder encontrar rápidamente los que me interesan.
- Como usuario, quiero poder guardar mis cambios en un archivo local CSV o base de datos SQL para poder recuperarlos después de cerrar la aplicación.
- Como usuario, quiero poder cargar una lista de Pokemons desde un archivo local CSV o base de datos SQLpara poder empezar a trabajar con mis datos existentes.
- Como usuario, quiero poder ver un mensaje de confirmación antes de borrar un Pokemon para evitar eliminarlo por error.
-Como usuario, quiero poder seleccionar un Pokemon de la lista y ver sus detalles en una ventana separada o en la consola para poder obtener más información sobre él.
- Como usuario, quiero poder editar los datos de un Pokemon seleccionado en su ventana de detalles para no tener que buscarlo en la lista y editarlos por separado.
- Como usuario, quiero recibir una notificación de error clara si intento actualizar un Pokemon con datos inválidos para evitar errores en los datos (nombres repetidos, campos vacios …).
- Como usuario, quiero poder conectar la aplicación a una base de datos relacional para tener una gestión más avanzada de mis datos de Pokemons.

## Modelo Vista y Controlador: Clases obligatorias

El patrón de diseño MVC (Modelo Vista Controlador) es una forma de organizar el código de una aplicación para separar las responsabilidades de cada componente y lograr una mayor modularidad y escalabilidad. El patrón MVC divide una aplicación en tres componentes principales:

- El Modelo: es responsable de manejar los datos y la lógica de negocio. El modelo representa los objetos y las operaciones de la aplicación que interactúan con los datos.
- La Vista: es responsable de presentar los datos del modelo al usuario en una forma visualmente atractiva e intuitiva. La vista recibe las entradas del usuario y las envía al controlador para su procesamiento.
- El Controlador: es responsable de manejar las interacciones entre la vista y el modelo. El controlador procesa las entradas del usuario, actualiza el modelo en consecuencia y actualiza la vista para reflejar los cambios en el modelo.

Todas las clases estáran en el paquete org.madrid

### org.infantaelena.modelo.entidades.Pokemon.java
En el paquete org.infantaelena.modelo.entidades está la clase Pokemon con todos los datos necesarios para guardar un pokemon (nombre, clase, características…)

### org.infantaelena.modelo.DAOPokemonDAO.java
En el paquete org.infantaelena.modelo.DAO debe utilizarse obligatoriamente la siguiente interfaz que puede implementarse mediante ficheros CSV o BBDD SQL.

### package org.infantaelena.modelo.DAO;

```
import org.infantaelena.modelo.entidades.Pokemon;

import java.util.List;

public interface PokemonDAO {

    // Método para crear un nuevo Pokemon 

    public void crear(Pokemon pokemon) throws PokemonRepeatedException;

    // Método para leer un Pokemon de la base de datos por su nombre

    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException;

    // Método para leer todos los Pokemons 

    public List<Pokemon> leerTodos() ;

    // Método para actualizar un Pokemon en la base de datos

    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException;

    // Método para eliminar un Pokemon por su nombre

    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException;

}

```

###  org.infantaelena.modelo.DAO.PokemonDAOImp.java
Implementación de la interfaz anterior mediante ficheros csv separados por punto y coma o una base de datos SQL.

### org.infantaelena.excepciones.PokemonRepeatedException.java
Excepción personalizada que se produce cuándo se intenta añadir un pokemon repetido. Esta debe ser tratada por el Controlador con un try catch.

### org.infantaelena.excepciones.PokemonNotFoundException.java
Excepción personalizada que que produce cuándo no se encuentra un pokemon para buscar, actualizar o borrar. Esta debe ser tratada por el Controlador con un try catch.

### org.infantaelena.vista.Vista.java
Clase con la vista que puede ser una interfaz gráfica o un menú de consola de texto. Debe ser independiente del modelo y del controlador y mostrar las siguientes opciones:

- Listar todos los Pokemones 
- Seleccionar un Pokemon
- Eliminar Pokemon sleccionado
- Actualizar Poemon seleccionado.
- Añadir Nuevo Pokemon

### org.infantaelena.controlador.Controlador.java
Clase que controla la vista (mediante interfaz gráfica o lecturas de scanner) y el modelo para la persistencia de la aplicación. 
Esta clase no debe implementar ningún elemento gráfico o usar Scanner, todos los datos se mostrarán o se pedirán a través de la vista.
```
package madrid.org.controlador;

import org.infantaelena.vista.Vista;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;

public class Controlador{

    private Vista vista;
    private PokemonDAOImp modelo;

    public Controlador(){

      vista = new Vista();
     modelo = new PokemonDAOImp();

    }
```


###  org.infantaelena.Main.java
Clase principal que instancia la clase controlador.

```
package madrid.org;

import org.infantaelena.controlador.Controlador;


public class Main

{

       public static void main(String args[]) {          

           new Controlador();

            }

}
```

Opcionalmente se pueden crear Test unitarios para probar los métodos de la interfaz.


## Entrega
Registrarse en Github Classroom en el siguiente enlace: https://classroom.github.com/classrooms/131652707-infantaelena2223-classroom-b90607
Crear el repositorio pulsando en el enlace de la activdad.
No debe cambiarla versión de JDK 11 ni el IDE (Intellij IDEA)

## Evaluación de la Tarea
La evaluación de la tarea se realizará mediante una rúbrica, que se aplicará únicamente si el material entregado cumple todos los requisitos arriba indicados, en caso contrario, la tarea será calificada como no apta.


