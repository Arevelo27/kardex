package com.todo1.systemkardex.servicio;

import com.todo1.systemkardex.dao.IPersonaDao;
import com.todo1.systemkardex.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    public Map<String, Object> initClient() {
        Map<String, Object> initCliente = new HashMap<>();
        var personas = (List<Persona>) personaDao.findAll();
        var saldoTotal = personas.stream().mapToDouble(a -> a.getSaldo()).sum();
        initCliente.put("personas", personas);
        initCliente.put("saldoTotal", saldoTotal);
        initCliente.put("totalClientes", personas.size());
        return initCliente;
    }

    @Override
    @Transactional
    public Persona guardar(Persona persona) {
        return personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
