package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.categoria;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCategoriaUseCase {

    private CategoriaRepository categoriaRepository;

    public void delete(CategoriaId id) {
        categoriaRepository.deteteById(id);
    }

}
