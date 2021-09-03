package com.todo1.systemkardex.dao;

import com.todo1.systemkardex.domain.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

    @Query("select c from Persona c where c.nombre=?1")
    Optional<Persona> findByPersona(String persona);
}
