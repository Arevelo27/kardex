package com.todo1.systemkardex.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo1.systemkardex.domain.Persona;
import com.todo1.systemkardex.servicio.IPersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static com.todo1.systemkardex.util.Datos.crearPersona001;
import static com.todo1.systemkardex.util.Datos.crearPersona002;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WithMockUser(username="admin",roles={"USER","ADMIN"})
@WebMvcTest(ControladorCliente.class)
class ControladorClienteTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IPersonaService personaService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @Disabled
    void testListar() throws Exception {
        // Given
        List<Persona> personas = Arrays.asList(crearPersona001().orElseThrow(), crearPersona002().orElseThrow());
        when(personaService.listarPersonas()).thenReturn(personas);

        // When
        mvc.perform(get("/cliente").contentType(MediaType.TEXT_HTML))
                // Then
                .andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(xpath("//input[@name='personas']").exists());
//                .andExpect(jsonPath("$[0].nombre").value("Carlos"))
//                .andExpect(jsonPath("$[1].nombre").value("Hilda"))
//                .andExpect(jsonPath("$[0].saldo").value(1000))
//                .andExpect(jsonPath("$[1].saldo").value(2000))
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(content().json(objectMapper.writeValueAsString(personas)));

        verify(personaService).listarPersonas();
    }

    @Test
    @Disabled
    void testGuardar() throws Exception {
        // Given
        Persona persona = new Persona(null, "Hilda", "Revelo", "hrevelo@mail.com", "554455", 2000);
        when(personaService.guardar(any())).then(invocation -> {
            Persona c = invocation.getArgument(0);
            c.setIdPersona(3L);
            return c;
        });

        // Whem
        mvc.perform(post("/cliente/guardar").contentType(MediaType.TEXT_HTML)
                        .content(objectMapper.writeValueAsString(persona)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8")))
                .andExpect(xpath("//input[@name='nombre']").exists())
                .andExpect(xpath("//input[@name='apellido']").exists())
                .andExpect(xpath("//input[@name='saldo']").exists());

        verify(personaService).guardar(any());

    }
}