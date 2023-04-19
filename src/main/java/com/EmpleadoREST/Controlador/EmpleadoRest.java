package com.EmpleadoREST.Controlador;

import com.EmpleadoREST.Modelo.Empleado;
import com.EmpleadoREST.Servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

/**
 * Esta clase define un controlador REST
 * @RequestMapping raíz de la URL de endpoints
 */
@RestController
@RequestMapping("/empleado/")
public class EmpleadoRest {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    /**
     * Metodo GET para obtener la lista completa de objetos Empleado creada en la base de datos MYSQL
     * @return eobjeto empleados con un http 200
     */
     @GetMapping("/empleados/")
    public ResponseEntity<List<Empleado>> buscarEmpleados() {
        List<Empleado> empleados = empleadoServicio.empleadoRepositorio.findAll();
        return ResponseEntity.ok(empleados);
    }
    /**
     * Metodo POST para obtener la lista completade atributos
     * de objetos Empleado con las validaciones requeridas de
     * Tiempo  de vinculacion y edad actual
     * @return objeto Empleado con validacion  con un http 201 created
     */
    @PostMapping("/empleados/")
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoGuardado = empleadoServicio.agregarEmpleado(empleado);
        return new ResponseEntity<>(empleadoGuardado, HttpStatus.CREATED);
    }
}
