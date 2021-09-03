package com.todo1.systemkardex.servicio;

import com.todo1.systemkardex.dao.IArticuloDao;
import com.todo1.systemkardex.domain.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticuloServiceImpl implements IArticuloService {

    @Autowired
    private IArticuloDao articuloDao;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return (List<Articulo>) articuloDao.findAll();
    }

    @Override
    public Map<String, Object> initArticulo() {
        Map<String, Object> initCliente = new HashMap<>();
        var articulos = (List<Articulo>) articuloDao.findAll();
        initCliente.put("articulos", articulos);
        initCliente.put("totalArticulos", articulos.size());
        return initCliente;
    }

    @Override
    @Transactional
    public Articulo guardar(Articulo articulo) {
        return articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void eliminar(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo encontrarArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
}
