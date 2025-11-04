package es.etg.daw.dawes.java.rest.restfull.productos.domain.error;

import es.etg.daw.dawes.java.rest.restfull.common.domain.error.EntityNotFoundException;

public class CategoriaNotFoundException extends EntityNotFoundException {

    private static final String ENTIDAD = "categoria";

    public CategoriaNotFoundException() {
        super(ENTIDAD);
    }

    public CategoriaNotFoundException(int id) {
        super(ENTIDAD, id);
    }

}
