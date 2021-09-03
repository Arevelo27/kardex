package com.todo1.systemkardex.dao;

import com.todo1.systemkardex.domain.Persona;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static com.todo1.systemkardex.util.Datos.PERSONA_001;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IPersonaDaoTest {

    @Autowired
    private IPersonaDao personaDao;

    @Test
    void testFindById() {
        Optional<Persona> persona = personaDao.findById(1L);
        assertTrue(persona.isPresent());
        assertEquals("Andres", persona.orElseThrow().getNombre());
    }

    @Test
    void testFindByPersona() {
        Optional<Persona> persona = personaDao.findByPersona("Andres");
        assertTrue(persona.isPresent());
        assertEquals("Andres", persona.orElseThrow().getNombre());
        assertEquals(100, persona.orElseThrow().getSaldo());
    }

    @Test
    void testFindByPersonaThrowException() {
        Optional<Persona> persona = personaDao.findByPersona("Andresy");
        assertThrows(NoSuchElementException.class, persona::orElseThrow);
        assertFalse(persona.isPresent());
    }

    @Test
    void testFindAll() {
        List<Persona> personas = (List<Persona>) personaDao.findAll();
        assertFalse(personas.isEmpty());
        assertEquals(2, personas.size());
    }

    @Test
    void testSave() {
//      Given
        Persona personaPepe = PERSONA_001;

//      When
        Persona persona = personaDao.save(personaPepe);

//      Then
        assertEquals("Carlos", persona.getNombre());
        assertEquals(3000, persona.getSaldo());

    }

    @Test
    void testUpdate() {
//      Given
        Persona personaPepe = PERSONA_001;

//      When
        Persona persona = personaDao.save(personaPepe);

//      Then
        assertEquals("Carlos", persona.getNombre());
        assertEquals(3000, persona.getSaldo());

//      When
        persona.setSaldo(3800);
        Persona personaActualizada = personaDao.save(persona);

//      Then
        assertEquals("Carlos", personaActualizada.getNombre());
        assertEquals(3800, personaActualizada.getSaldo());
    }

    @Test
    void testDelete() {
        Persona persona = personaDao.findById(2L).orElseThrow();
        assertEquals("Juan", persona.getNombre());

        personaDao.delete(persona);

        assertThrows(NoSuchElementException.class, ()-> {
            personaDao.findByPersona("Juan").orElseThrow();
        });
        assertEquals(1, ((Collection<?>) personaDao.findAll()).size());
    }

}