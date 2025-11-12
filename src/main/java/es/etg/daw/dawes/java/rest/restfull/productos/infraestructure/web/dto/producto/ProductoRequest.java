package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto;

import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.validation.NombradoProducto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ProductoRequest(
                @NotBlank (message = "{producto.valid.nombre.no_vacio}")
                @NombradoProducto (message = "{producto.valid.nombre.nombrado_validation}")
                    String nombre, 
                @Min(value = 0, message = "{producto.valid.precio.min}") 
                @Max(value = 100, message = "{producto.valid.precio.max}")
                    double precio) {

}
