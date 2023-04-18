# EmpleadoRESTful

API RESTful con Java 11 y Spring Boot
Este proyecto es una API (Get - POST) que implementa una API RESTful para realizar operaciones CRUD (Crear, Leer) sobre una base de datos MYSQL para un objeto Empleado. La aplicación está escrita en Java 11 y utiliza el framework de Spring Boot.

Requisitos
Para ejecutar la aplicación, se requiere lo siguiente:

Java Development Kit (JDK) 11 o superior
Maven 3.6.0 o superior
Instalación y configuración
Clonar el repositorio de GitHub:
bash
Copy code
git clone https://github.com/tu_usuario/tu_proyecto.git
Ingresar a la carpeta del proyecto:
bash
Copy code
cd tu_proyecto
Compilar el proyecto:
Copy code
mvn clean install
Ejecutar la aplicación:
arduino
Copy code
mvn spring-boot:run
La aplicación se ejecutará en el puerto 8080. Para acceder a la API, utiliza la siguiente URL: http://localhost:8080/api/users.

Endpoints disponibles
La aplicación implementa los siguientes endpoints:

GET /api/users: Retorna una lista de todos los usuarios.
GET /api/users/{id}: Retorna un usuario por su ID.
POST /api/users: Crea un nuevo usuario.
PUT /api/users/{id}: Actualiza un usuario existente.
DELETE /api/users/{id}: Elimina un usuario existente.
Tecnologías utilizadas
Java 11
Spring Boot 2.5.4
Spring Data JPA
MYSQL
Maven
Contribuciones
Si deseas contribuir a este proyecto, puedes hacer lo siguiente:

Realiza un fork del proyecto.
Crea una nueva rama para tu contribución.
Realiza tus cambios y haz commit a tu rama.
Crea un pull request para que tus cambios sean incorporados al proyecto.
Licencia
Este proyecto está bajo la licencia MIT. Puedes leer el archivo de licencia completo 
