/**
 * 
 * @author Nuhaila Assaid Aabdenour 
 */
package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.error.CategoriaNotFoundException;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditCategoriaUseCase {
    
    private final CategoriaRepository categoriaRepository;
    
    public Categoria update(EditCategoriaCommand command){
        return categoriaRepository.getById(command.id())
                .map(c -> {  //Actualizamos los atributos del objeto
                    c.setNombre(command.nombre());
                    return categoriaRepository.save(c);})
                .orElseThrow(() -> new CategoriaNotFoundException(command.id().getValue()));

    }
}
