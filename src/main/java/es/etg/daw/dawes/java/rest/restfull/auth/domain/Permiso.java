package es.etg.daw.dawes.java.rest.restfull.auth.domain;


import lombok.Getter;

public enum Permiso {
    ADMIN_CREATE("admin:create"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),
    
    USER_CREATE("user:create"),
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete");  

    @Getter
    private final String permiso;

    private Permiso(String value){
        permiso = value;
    }
}