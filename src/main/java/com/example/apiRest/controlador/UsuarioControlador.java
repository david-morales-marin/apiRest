package com.example.apiRest.controlador;

import com.example.apiRest.modelo.Usuario;
import com.example.apiRest.dao.DaoUsuario;
import com.example.apiRest.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

      @Autowired
      public DaoUsuario daoUsuario;
      @Autowired
      public RepositorioUsuario repositorioUsuario;

      @GetMapping
      public List<Usuario> consulta(){

          return daoUsuario.consultar();
      }

      @PostMapping
      public Usuario guardar(@RequestBody Usuario usuario){
            return this.repositorioUsuario.save(usuario);
      }

      @GetMapping(path = "/{id}" )
      public Optional<Usuario> consultarId(@PathVariable("id")Long id){
            return this.repositorioUsuario.ConsultarPorId(id);
      }

      @DeleteMapping(path = "/{id}")
      public ResponseEntity<Object> deleteUsuario(@PathVariable Long id){
            this.repositorioUsuario.deleteById(id);
            return ResponseEntity.ok(Boolean.TRUE);
      }

      @PutMapping(path = "/{id}")
      public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
            Usuario actualizar = null;
            int pos = 0;
            int aux = 0;
            for (Usuario usuario1: consulta()) {
                  if(usuario1.getId().equals(id)){
                        actualizar=usuario1;
                        aux = pos;
                  }
                pos++;
            }
            actualizar.setNombre(usuario.getNombre());
            actualizar.setApellido(usuario.getApellido());
            actualizar.setCelular(usuario.getCelular());
            actualizar.setEmail(usuario.getEmail());

            consulta().remove(aux);
            consulta().add(aux, usuario);

            for(Usuario usuario1: consulta()){
                  System.out.println("Su lista fue actualizada correctamente " + usuario1);
            }
            this.repositorioUsuario.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
      }

}
