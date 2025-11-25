/**
 * 
 * @author Nuhaila Assaid Aabdenour 
 */
package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategoriaUseCase {
    
    private CategoriaRepository categoriaRepository;

    public Categoria create(CreateCategoriaCommand comando){

        Categoria categoria = Categoria.builder() // Se puede usar comando.id y no getId por usar @Accessors(fluent = true) la clase CreateProductoCommand 
                                    .nombre(comando.nombre())
                                    .createdAt(LocalDateTime.now()).build();

        
        return categoriaRepository.save(categoria);
        

    }
}
