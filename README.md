# EmpleadoRESTful
API RESTful con Java 11 y Spring Boot
Este proyecto es una API (Get - POST) que implementa una API RESTful para realizar operaciones CRUD (Crear, Leer) sobre una base de datos MYSQL para un objeto Empleado. La aplicación está escrita en Java 11 y utiliza el framework de Spring Boot.

-----------
Requisitos 
Para ejecutar la aplicación, se requiere lo siguiente:
Java Development Kit (JDK) 11 o superior
Maven 3.6.0 o superior

-----------
Configuración y Uso
Clonar el repositorio de GitHub:
     "git@github.com:williamangaritac/EmpleadoRESTful.git"

crear una DB en MySQL con el siguiente comando "Aqui se uso phpMyAdmin":
query en MYSQL: CREATE DATABASE empleado_rest;

La aplicación se ejecutará en el puerto 8080. Para acceder a la API:
Para GET Y POST Endpoints disponibles: 
URL: http://localhost:8080/empleado/empleados/

-----------
Consumo Con POSTMAN en solicitud POST
http://localhost:8080/empleado/empleados/
ejemplo JSON a consumir 
"{
    "nombres": "brayan",
    "apellidos": "avendaño",
    "tipo_documento": "Cédula",
    "numero_documento": "123456789",
    "fecha_nacimiento": "1992-03-20",
    "fecha_vinculacion": "2019-09-01",
    "cargo": "Analista",
    "salario": 2500.00"
    
-----------
Contribuciones
Si deseas contribuir a este proyecto, puedes hacer lo siguiente:

Realiza un fork del proyecto.
Crea una nueva rama para tu contribución.
Realiza tus cambios y haz commit a tu rama.
Crea un pull request para que tus cambios sean incorporados al proyecto.
Licencia
Este proyecto está bajo la licencia MIT. Puedes leer el archivo de licencia completo 
