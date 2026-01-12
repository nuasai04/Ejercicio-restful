package es.etg.daw.dawes.java.rest.restfull.auth.domain;


import java.util.Set;

import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.ADMIN_CREATE;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.ADMIN_DELETE;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.ADMIN_READ;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.ADMIN_UPDATE;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.USER_CREATE;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.USER_DELETE;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.USER_READ;
import static es.etg.daw.dawes.java.rest.restfull.auth.domain.Permiso.USER_UPDATE;
import lombok.Getter;

public enum Rol {
    
    USER(
        Set.of(
            USER_CREATE,
            USER_READ,
            USER_UPDATE,
            USER_DELETE
        )
    ),
    ADMIN(
        Set.of(
            USER_CREATE,
            USER_READ,
            USER_UPDATE,
            USER_DELETE,
            
            ADMIN_CREATE,
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE
        )
    );

    @Getter
    private final Set<Permiso> permisos;

    private Rol(Set<Permiso> values){
        permisos = values;
    }
}