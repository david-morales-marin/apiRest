package com.example.apiRest.repositorio;

import com.example.apiRest.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {


    public Usuario save(Usuario usuario);

    public abstract List<Usuario> findById(Integer id);

    public default Optional<Usuario> ConsultarPorId(Long id){
        return Usuario.findById(id);
    }

    @Override
    void deleteById(Long id);

   // void updateById(Long id);


}
