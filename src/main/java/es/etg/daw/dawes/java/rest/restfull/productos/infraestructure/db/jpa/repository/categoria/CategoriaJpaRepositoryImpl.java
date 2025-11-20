package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.repository.categoria;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.jpa.entity.CategoriaEntity;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaJpaRepositoryImpl implements CategoriaRepository {

    private final CategoriaEntityJpaRepository repository;

    @Override
    public Categoria save(Categoria t) {

        CategoriaEntity cat = CategoriaMapper.toEntity(t);
        return CategoriaMapper.toDomain(repository.save(cat));
    }

    @Override
    public List<Categoria> getAll() {
        return CategoriaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        Optional<Categoria> categoria = null;
        Optional<CategoriaEntity> ce = repository.findById(id.getValue());

        if (ce.isEmpty()) {
            categoria = Optional.empty();
        } else {
            categoria = Optional.of(CategoriaMapper.toDomain(ce.get()));
        }

        return categoria;
    }

    @Override
    public void deteteById(CategoriaId id) {
        repository.deleteById(id.getValue());
    }
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(),
    // etc.
    
}
