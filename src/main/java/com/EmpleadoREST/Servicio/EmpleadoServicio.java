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
 * Esta es una clase basado en modelo arquitectura MVC en java 11
 * ES es la clase @Empleado servicio que implementa la logica y las validaciones del backend
 */
@Service
public class EmpleadoServicio {

    /***
     * Implementacion del concepto inyeccion de dependencias de roro
     */
    @Autowired
    public EmpleadoRepositorio empleadoRepositorio;
    @Autowired
    public EmpleadoRepositorio empleadoRepositorio() {
        return empleadoRepositorio;
    }

    /**
     * Agregar datos de prueba
     */

    //Revisar postconstruct
    @PostConstruct
    public void agregarDatosDePrueba() {
        empleadoRepositorio = empleadoRepositorio();
        Empleado emp1 = new Empleado("Pedro", "González", "Cédula", "234567890", LocalDate.of(1995, 5, 20),
                LocalDate.of(2018, 7, 1), "Analista", 3000.00);
        empleadoRepositorio.save(emp1);

        Empleado emp2 = new Empleado("Ana", "Martínez", "Pasaporte", "A1234567", LocalDate.of(1988, 9, 14),
                LocalDate.of(2009, 3, 15), "Gerente de Ventas", 6000.00);
        empleadoRepositorio.save(emp2);
    }

    /// Metodo que reune los submetodos con las validaciones requeridas
    public Empleado agregarEmpleado(Empleado empleado) {
        validarEmpleado(empleado);
        calcularTiempoVinculacion(empleado);
        calcularEdadActual(empleado);
        return empleadoRepositorio.save(empleado);
    }

    /**
     * @author: William Angarita
     * @param empleado
     * @return
     */
    /// metodo calcula la edad empleado
    private void calcularEdadActual(Empleado empleado) {
        LocalDate fechaNacimiento = LocalDate.parse(empleado.getFecha_nacimiento());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        empleado.setEdad_actual(periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días");
    }

    private void calcularTiempoVinculacion(Empleado empleado) {
        LocalDate fechaVinculacion = LocalDate.parse(empleado.getFecha_vinculacion());
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaVinculacion, fechaActual);
        LocalDate tiempoVinculacion = fechaVinculacion.plusYears(periodo.getYears()).plusMonths(periodo.getMonths()).plusDays(periodo.getDays());
        Period periodoVinculacion = Period.between(fechaVinculacion, tiempoVinculacion);
        empleado.setTiempo_vinculacion(periodoVinculacion.getYears() + " años, " + periodoVinculacion.getMonths() + " meses, " + periodoVinculacion.getDays() + " días");
    }

    /// Metodo Validacion de atributos no vacios
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

        LocalDate fechaNacimiento = LocalDate.parse(empleado.getFecha_nacimiento());

        /// Validacion para comprobar si empleado es mayor de edad 18años,
        if (fechaNacimiento.plusYears(18).isAfter(LocalDate.now())) {
            throw new RuntimeException("El empleado debe ser mayor de edad");
        }
    }
}
