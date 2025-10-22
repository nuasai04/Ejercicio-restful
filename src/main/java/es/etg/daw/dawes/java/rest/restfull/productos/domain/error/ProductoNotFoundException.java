package es.etg.daw.dawes.java.rest.restfull.productos.domain.error;

public class ProductoNotFoundException extends EntityNotFoundException {

    public static final String ENTIDAD = "producto";

    public ProductoNotFoundException(){
        super(ENTIDAD);
    }

    public ProductoNotFoundException(int id){
        super(ENTIDAD, id);
    }
    
}