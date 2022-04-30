package com.example.apiRest.dao;

import com.example.apiRest.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DaoUsuario extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT * FROM usuario",nativeQuery = true)
    public List<Usuario> consultar();




}
