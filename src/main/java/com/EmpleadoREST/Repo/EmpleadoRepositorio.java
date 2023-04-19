package com.EmpleadoREST.Repo;

import com.EmpleadoREST.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Se usa Interfaz para extneder de JPA Repository en  Spring Data
 * para persistir en DB MYSQL
 *
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
