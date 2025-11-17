package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.validation.NombradoProducto;
import jakarta.validation.constraints.NotBlank;

public record CategoriaRequest(
        @NotBlank(message = "{categoria.valid.nombre.no_vacio}") @NombradoProducto(message = "{categoria.valid.nombre.nombrado_validation}") String nombre) {

    public CategoriaRequest(Categoria c) {
        this(c.getNombre());
    }
}
