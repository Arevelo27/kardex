package com.todo1.systemkardex.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotEmpty
    private String nombre;

    @NotEmpty(message = "El campo Apellido, no debe estar vacío")
    private String apellido;

    @NotEmpty
    @Email
    private String email;
    private String telefono;

    @NotNull
    private double saldo;

    public Persona() {
    }

    public Persona(Long idPersona, String nombre, String apellido, String email, String telefono, double saldo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.saldo = saldo;
    }
}
