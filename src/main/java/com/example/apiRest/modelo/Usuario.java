package com.example.apiRest.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Optional;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = -4431929601983510578L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name="nombre", length = 29 )
    private String nombre;
    @Column(name="apellido", length = 29 )
    private String apellido;
    @Column(name="celular", length = 29 )
    private String celular;
    @Column(name="email", length = 39 )
    private String email;

    public static Optional<Usuario> findById(Long id) {
        return Usuario.findById(id);
    }

    public static void updateById(Usuario usuario){

    }

    public static void deleteById(Long id) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario() {

    }

    public Usuario( String nombre, String apellido, String celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }
}

