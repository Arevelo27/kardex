package com.todo1.systemkardex.servicio;


import com.todo1.systemkardex.domain.Persona;

import java.util.List;
import java.util.Map;

public interface IPersonaService {

    public List<Persona> listarPersonas();

    public Map<String, Object> initClient();

    Persona guardar(Persona person);

    public void eliminar(Persona person);

    public Persona encontrarPersona(Persona persona);
}
