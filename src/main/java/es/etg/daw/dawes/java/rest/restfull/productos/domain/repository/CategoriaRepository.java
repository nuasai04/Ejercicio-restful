package es.etg.daw.dawes.java.rest.restfull.productos.domain.repository;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;

public interface CategoriaRepository extends CRUDRepository<Categoria, CategoriaId> {
    //public Optional<Categoria> getByName(String name);
}
