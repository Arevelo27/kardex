package com.todo1.systemkardex.dao;

import com.todo1.systemkardex.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
