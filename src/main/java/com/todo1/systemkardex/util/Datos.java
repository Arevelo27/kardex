package com.todo1.systemkardex.util;

import com.todo1.systemkardex.domain.Persona;

import java.util.Optional;

public class Datos {

    public static final Persona PERSONA_001 = new Persona(1L, "Carlos", "Perez", "cperez@mail.com", "1122333", 3000);

    public static Optional<Persona> crearPersona001() {
        return Optional.of(new Persona(1L, "Carlos", "Perez", "cperez@mail.com", "1122333", 1000));
    }

    public static Optional<Persona> crearPersona002() {
        return Optional.of(new Persona(1L, "Hilda", "Revelo", "hrevelo@mail.com", "554455", 2000));
    }
}
