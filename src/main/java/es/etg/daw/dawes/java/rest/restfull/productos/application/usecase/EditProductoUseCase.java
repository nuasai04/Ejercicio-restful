package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditProductoUseCase {

    public Producto update(EditProductoCommand command) {
        Producto productoNuevo = Producto.builder()
                                            .id(command.id())
                                            .precio(command.precio())
                                            .nombre(command.nombre()).build();
        return productoNuevo;
    }

}
