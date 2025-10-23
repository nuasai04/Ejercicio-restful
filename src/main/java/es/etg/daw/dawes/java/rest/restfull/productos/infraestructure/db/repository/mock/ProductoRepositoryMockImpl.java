package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;

@Repository
public class ProductoRepositoryMockImpl implements ProductoRepository {

    private final Map<Integer, Producto> productos = ProductoFactory.getDemoData();

    @Override
    public Producto save(Producto t) {
        if(t.getId() == 0) {
            t.setId(obtenerSiguienteId());
        }
        productos.put(t.getId(), t);
        return t;
    }


    private int obtenerSiguienteId(){
        return productos.size()+1;
    }


    @Override
    public List<Producto> getAll() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public Optional<Producto> getById(Integer id) {
        //Un optional puede tener una valor o no. Si no existe el producto devuelve Optional.empty
        return Optional.ofNullable(productos.get(id));
    }

    @Override
    public void deteteById(Integer id) {
        productos.remove(id);
    }

    @Override
    public Optional<Producto> getByName(String name) {
        // TODO Sin implementar
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
    
}
