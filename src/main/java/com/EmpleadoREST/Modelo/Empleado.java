package com.EmpleadoREST.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table (name = "empleado")
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "numero_documento")
    private String numero_documento;

    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;

    @Column(name = "fecha_vinculacion")
    private String fecha_vinculacion;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "tiempo_vinculacion")
    private String tiempo_vinculacion;

    @Column(name = "edad_actual")
    private String edad_actual;

    public Empleado(String pedro, String gonzález, String cédula, String s, LocalDate of, LocalDate of1, String analista, double v) {
    }
}
