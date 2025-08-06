# Videojuego de Batalla por Turnos

## Descripción del Proyecto

Este proyecto consiste en un **juego de batalla por turnos** en el que los jugadores seleccionan su personaje, eligen su raza y arma, y luego se enfrentan en una pelea. 
El sistema almacena estadísticas como victorias y derrotas, y registra las partidas en una base de datos SQL Server.

## Tecnologías Utilizadas

- **Java**: El lenguaje de programación utilizado para implementar el juego.
- **SQL Server**: Base de datos utilizada para almacenar las tablas y registros de los jugadores, razas, armas y personajes.
- **JDBC**: Para la conexión entre la aplicación Java y la base de datos SQL Server.
- **NetBeans**: Entorno de desarrollo utilizado para escribir y ejecutar el código.

## Estructura del Proyecto

El proyecto está organizado en varias clases, cada una con una funcionalidad específica:

- **`Juego.java`**: Contiene la lógica del juego, como la creación de personajes, el combate y la actualización de estadísticas.
- **`Jugador.java`**: Representa a un jugador, con atributos como el nombre y las estadísticas de victorias y derrotas.
- **`Personaje.java`**: Define las características de un personaje, incluyendo su raza, arma y estadísticas.
- **`Arma.java`**: Define las armas disponibles en el juego, incluyendo el tipo de daño que causan.
- **`Raza.java`**: Define las razas disponibles para los personajes.
- **`Persistencia.java`**: Contiene los métodos para interactuar con la base de datos, como insertar o actualizar registros de jugadores y personajes.

## Instalación

### Requisitos previos:

- Tener **Java** instalado (preferentemente JDK 8 o superior).
- Tener un **servidor SQL Server** corriendo.
- **NetBeans** o cualquier otro IDE para ejecutar proyectos Java.

### Pasos para ejecutar el proyecto:

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/videojuego-batalla.git

Abre el proyecto en NetBeans.

Configura la base de datos SQL Server y crea la base de datos VideojuegoCombate.

Ejecuta las consultas SQL para crear las tablas y agregar los datos iniciales (arma, raza, jugadores) en tu base de datos.

Ejemplo de consultas:

Crear la base de datos:


CREATE DATABASE VideojuegoCombate;
Crear las tablas arma, raza, jugador y personaje como se especificó en el código SQL de la práctica.

Asegúrate de que las credenciales para conectarte a la base de datos estén configuradas correctamente en el código Java en Persistencia.java.

Ejecuta el proyecto y disfruta de tu juego de batalla por turnos.

Base de Datos
El proyecto utiliza una base de datos SQL Server llamada VideojuegoCombate, que tiene las siguientes tablas:

arma: Almacena las armas disponibles para los personajes. Tiene columnas como id, nombre, tipo, dano_minimo, dano_maximo y modificadores.

raza: Almacena las razas disponibles para los personajes. Tiene columnas como id, nombre y descripcion.

jugador: Almacena los jugadores y sus estadísticas de partidas ganadas y perdidas. Tiene columnas como id, nombre, partidas_ganadas y partidas_perdidas.

personaje: Almacena los personajes, con su raza y arma asignada. Tiene columnas como id, nombre, raza_id, fuerza, energia, vida_actual y id_arma.

Cómo Funciona el Juego
Selección de Jugadores: Los jugadores ingresan sus nombres y eligen su personaje.

Selección de Raza y Arma: Los jugadores eligen una raza (Humano, Elfo, Orco, Bestia) y un arma (por ejemplo, Escopeta, Hacha, Espada).

Combate: El juego alterna los turnos de cada jugador, quien puede atacar al otro jugador y causar daño según las características del personaje y el arma.

Actualización de Estadísticas: Al final de cada partida, las estadísticas de victorias y derrotas de los jugadores se actualizan en la base de datos.

Conclusión
Este proyecto permite simular un combate entre dos jugadores, con una base de datos para guardar los registros de victorias y derrotas. 
Puedes expandir el proyecto para incluir más características, como habilidades especiales para cada raza, objetos de equipo, o un sistema de puntos de experiencia.

Integrantes del Proyecto
- Benjamin Bolaños Alpizar
- Pamela Espinoza Potoy

Curso
Este proyecto fue realizado como parte del curso "Programación en Java" para la carrera de Ingeniería en Tecnologías de la Información.

