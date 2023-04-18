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

@RestController
@RequestMapping("/empleado/")
public class EmpleadoRest {

    @Autowired
    private EmpleadoServicio empleadoServicio;

     @GetMapping("/empleados/")
    public ResponseEntity<List<Empleado>> buscarEmpleados() {
        List<Empleado> empleados = empleadoServicio.empleadoRepositorio.findAll();
        return ResponseEntity.ok(empleados);
    }

    @PostMapping("/empleados/")
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoGuardado = empleadoServicio.agregarEmpleado(empleado);
        return new ResponseEntity<>(empleadoGuardado, HttpStatus.CREATED);
    }
}
