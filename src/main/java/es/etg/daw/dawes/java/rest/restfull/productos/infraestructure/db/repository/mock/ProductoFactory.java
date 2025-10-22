package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;

public class ProductoFactory {
    
    public static final Map<Integer, Producto> getDemoData(){
        Map<Integer, Producto> datos = new LinkedHashMap<>();

        datos.put(1, new Producto(1, "Nombre producto 1", 1.01, LocalDateTime.now()));
        datos.put(2, new Producto(2, "Nombre producto 2", 1.02, LocalDateTime.now()));
        datos.put(3, new Producto(3, "Nombre producto 3", 1.03, LocalDateTime.now()));
        datos.put(4, new Producto(4, "Nombre producto 4", 1.04, LocalDateTime.now()));
        
        return datos;
    }
}