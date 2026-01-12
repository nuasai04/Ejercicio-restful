package es.etg.daw.dawes.java.rest.restfull.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Usuario {
    
    // Atributos
    private UsuarioId id;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private Rol rol;
}