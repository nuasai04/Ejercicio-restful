package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindProductoUseCase {


    public List<Producto> findAll(){
        //TODO Habría que implementarlo con un acceso real a los datos. 
        // lo vamos a simular
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(1, "Producto1", 1, LocalDateTime.now()));
        lista.add(new Producto(2, "Producto2", 1, LocalDateTime.now()));
        lista.add(new Producto(3, "Producto3", 1, LocalDateTime.now()));

        return lista;

    }
    
}