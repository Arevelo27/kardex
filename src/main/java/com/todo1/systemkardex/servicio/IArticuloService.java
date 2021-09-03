package com.todo1.systemkardex.servicio;


import com.todo1.systemkardex.domain.Articulo;

import java.util.List;
import java.util.Map;

public interface IArticuloService {

    public List<Articulo> listarArticulos();

    public Map<String, Object> initArticulo();

    Articulo guardar(Articulo articulo);

    public void eliminar(Articulo articulo);

    public Articulo encontrarArticulo(Articulo articulo);
}
