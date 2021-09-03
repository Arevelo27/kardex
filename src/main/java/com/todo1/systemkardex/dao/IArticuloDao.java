package com.todo1.systemkardex.dao;

import com.todo1.systemkardex.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface IArticuloDao extends CrudRepository<Articulo, Long> {
}
