package com.EmpleadoREST.Servicio;

/**
 * Importaciones de dependencias y Anotaciones Tipo Decoradores
 */

import com.EmpleadoREST.Modelo.Empleado;
import com.EmpleadoREST.Repo.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;

/***
 * Esta es una clase basada en modelo arquitectura MVC en java 11 y Spring Boot
 * Esta es la Clase @Empleado servicio que implementa la logica y las validacions del backend
 * @author: William Angarita
 */

@Service
public class EmpleadoServicio {

    /***
     * Implementacion del concepto inyeccion de dependencias
     */
    @Autowired
    public EmpleadoRepositorio empleadoRepositorio;

    /**
     * Se inicia la logica del service Agregando 2 objeto Empleado de prueba inicial
     */
    @PostConstruct
    public void cargarDatosDePrueba() {
        Empleado empleado1 = new Empleado();
        empleado1.setNombres("Luis");
        empleado1.setApellidos("González");
        empleado1.setTipo_documento("Cédula");
        empleado1.setNumero_documento("123456789");
        LocalDate fechaNacimiento = LocalDate.parse("1988-03-20");
        empleado1.setFecha_nacimiento(String.valueOf(fechaNacimiento));
        LocalDate fechaVinculacion = LocalDate.parse("2016-09-01");
        empleado1.setFecha_vinculacion(String.valueOf(fechaVinculacion));
        empleado1.setCargo("Analista");
        empleado1.setSalario(3500.00);

        Empleado empleado2 = new Empleado();
        empleado2.setNombres("María");
        empleado2.setApellidos("García");
        empleado2.setTipo_documento("Cédula");
        empleado2.setNumero_documento("987654321");
        LocalDate fechaNacimiento2 = LocalDate.parse("1990-02-15");
        empleado2.setFecha_nacimiento(String.valueOf(fechaNacimiento2));
        LocalDate fechaVinculacion2 = LocalDate.parse("2018-01-01");
        empleado2.setFecha_vinculacion(String.valueOf(fechaVinculacion2));
        empleado2.setCargo("Desarrollador");
        empleado2.setSalario(4500.00);

        agregarEmpleado(empleado1);
        agregarEmpleado(empleado2);
    }
   /**
     * Metodo que reune los submetodos con las validaciones requeridas
     * @param empleado
     * @return empleado
    */
    public Empleado agregarEmpleado(Empleado empleado) {
        validarEmpleado(empleado);
        calcularTiempoVinculacion(empleado);
        calcularEdadActual(empleado);
        return empleadoRepositorio.save(empleado);
    }

    /**
     * Metodo para calcular la edad del Empleado
     * @param empleado
     * @return
     */    
    private void calcularEdadActual(Empleado empleado) {
        LocalDate fechaNacimiento = LocalDate.parse(empleado.getFecha_nacimiento());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        empleado.setEdad_actual(periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días");
    }

     /**
     * Metodo para calcular el tiempo de vinculacion usando la clase @param LocalDate
     * @param empleado
     * @param periodo
     * @return empleado Period
     */  
    private void calcularTiempoVinculacion(Empleado empleado) {
        LocalDate fechaVinculacion = LocalDate.parse(empleado.getFecha_vinculacion());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaVinculacion, fechaActual);
        LocalDate tiempoVinculacion = fechaVinculacion.plusYears(periodo.getYears()).plusMonths(periodo.getMonths()).plusDays(periodo.getDays());
        Period periodoVinculacion = Period.between(fechaVinculacion, tiempoVinculacion);
        empleado.setTiempo_vinculacion(periodoVinculacion.getYears() + " años, " + periodoVinculacion.getMonths() + " meses, " + periodoVinculacion.getDays() + " días");
    }

    /**
     * Metodo Validacion de atributos no vacios
     * @param empleado de tipo @Empleado
     * @return 
     */
      private void validarEmpleado(Empleado empleado) {
        if (empleado.getNombres() == null || empleado.getNombres().isEmpty()) {
            throw new RuntimeException("El nombre del empleado es requerido");
        }
        if (empleado.getApellidos() == null || empleado.getApellidos().isEmpty()) {
            throw new RuntimeException("Los apellidos del empleado son requeridos");
        }
        if (empleado.getTipo_documento() == null || empleado.getTipo_documento().isEmpty()) {
            throw new RuntimeException("El tipo de documento del empleado es requerido");
        }
        if (empleado.getNumero_documento() == null || empleado.getNumero_documento().isEmpty()) {
            throw new RuntimeException("El número de documento del empleado es requerido");
        }
        if (empleado.getFecha_nacimiento() == null || empleado.getFecha_nacimiento().isEmpty()) {
            throw new RuntimeException("La fecha de nacimiento del empleado es requerida");
        }
        if (empleado.getFecha_vinculacion() == null) {
            throw new RuntimeException("La fecha de vinculación del empleado es requerida");
        }
        if (empleado.getCargo() == null || empleado.getCargo().isEmpty()) {
            throw new RuntimeException("El cargo del empleado es requerido");
        }
        if (empleado.getSalario() == null) {
            throw new RuntimeException("El salario del empleado es requerido");
        }

        // Creacion de variable para parsear string a objeto LocaDate para manejo de fechas con norma IOS 8601 "2007-12-03"
        LocalDate fechaNacimiento = LocalDate.parse(empleado.getFecha_nacimiento());

        /**
         * Validacion para comprobar si empleado es mayor de edad 18años
         * @param fechaNacimiento
         * @return boolean
         */
        if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now())) {
            throw new RuntimeException("El empleado debe ser mayor de edad");
        }
    }
}
