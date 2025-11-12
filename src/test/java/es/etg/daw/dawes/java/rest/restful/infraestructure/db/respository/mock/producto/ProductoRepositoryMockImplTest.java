package es.etg.daw.dawes.java.rest.restful.infraestructure.db.respository.mock.producto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.producto.ProductoFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.producto.ProductoRepositoryMockImpl;

public class ProductoRepositoryMockImplTest {

    ProductoRepository repository = new ProductoRepositoryMockImpl();

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new ProductoRepositoryMockImpl();

    }

    @Test
    void save() {
        var producto = ProductoFactory.create();

        Producto p = repository.save(producto);

        assertAll(
                () -> assertNotNull(p), // el producto no es nulo
                () -> assertNotNull(p.getId()), // el producto creado tiene id
                () -> assertNotNull(repository.getById(p.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        var productos = repository.getAll();

        assertAll(
                () -> assertNotNull(productos),
                () -> assertEquals(ProductoFactory.getDemoData().size(), productos.size()));
    }

    @Test
    void getById() {
        int idEsperado = 1;
        var producto = repository.getById(new ProductoId(idEsperado));

        assertAll(
                () -> assertNotNull(producto),
                () -> assertEquals(idEsperado, producto.get().getId().getValue()));

    }

    @Test
    void deleteById() {
        int idEsperado = 1;
        repository.deteteById(new ProductoId(idEsperado));
        var producto = repository.getById(new ProductoId(idEsperado));

        assertAll(
                () -> assertNotNull(producto),
                () -> assertEquals(false, producto.isPresent()));

    }

}
