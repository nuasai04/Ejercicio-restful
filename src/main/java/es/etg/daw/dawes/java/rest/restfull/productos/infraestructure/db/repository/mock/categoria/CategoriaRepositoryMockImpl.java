package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.categoria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;

@Repository
public class CategoriaRepositoryMockImpl implements CategoriaRepository {

    private final Map<CategoriaId, Categoria> categorias = CategoriaFactory.getDemoData();

    @Override
    public Categoria save(Categoria t) {
        if (t.getId() == null)
            t.setId(new CategoriaId(obtenerSiguienteId()));

        categorias.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        CategoriaId ultimo = null;
        if (!categorias.isEmpty()) {
            Collection<Categoria> lista = categorias.values();

            for (Categoria c : lista) {
                ultimo = c.getId();
            }

        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Categoria> getAll() {
        return new ArrayList<>(categorias.values());
    }

    @Override
    public Optional<Categoria> getById(CategoriaId id) {
        return Optional.ofNullable(categorias.get(id));
    }

    @Override
    public void deteteById(CategoriaId id) {
        categorias.remove(id);

    }
}
