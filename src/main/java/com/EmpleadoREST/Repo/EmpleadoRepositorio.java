package com.EmpleadoREST.Repo;

import com.EmpleadoREST.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
