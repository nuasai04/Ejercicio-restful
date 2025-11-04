package es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@AllArgsConstructor
@Accessors(fluent = true)
public class EditCategoriaCommand {
    private CategoriaId id;
    private String nombre;
}
