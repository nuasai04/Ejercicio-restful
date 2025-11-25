/**
 * 
 * @author Nuhaila Assaid Aabdenour 
 */
package es.etg.daw.dawes.java.rest.restfull.infraestructure.db.respository.mock.categoria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.CategoriaRepository;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.categoria.CategoriaFactory;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.categoria.CategoriaRepositoryMockImpl;

public class CategoriaRepositoryMockImplTest {

    CategoriaRepository repository = new CategoriaRepositoryMockImpl();

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new CategoriaRepositoryMockImpl();

    }

    @Test
    void save() {
        var categoria = CategoriaFactory.create();

        Categoria c = repository.save(categoria);

        assertAll(
                () -> assertNotNull(c), // categoria no es nulo
                () -> assertNotNull(c.getId()), // categoria creado tiene id
                () -> assertNotNull(repository.getById(c.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        var categorias = repository.getAll();

        assertAll(
                () -> assertNotNull(categorias),
                () -> assertEquals(CategoriaFactory.getDemoData().size(), categorias.size()));
    }

    @Test
    void getById() {
        int idEsperado = 1;
        var categoria = repository.getById(new CategoriaId(idEsperado));

        assertAll(
                () -> assertNotNull(categoria),
                () -> assertEquals(idEsperado, categoria.get().getId().getValue()));

    }

    @Test
    void deleteById() {
        int idEsperado = 1;
        repository.deteteById(new CategoriaId(idEsperado));
        var categoria = repository.getById(new CategoriaId(idEsperado));

        assertAll(
                () -> assertNotNull(categoria),
                () -> assertEquals(false, categoria.isPresent()));

    }

}