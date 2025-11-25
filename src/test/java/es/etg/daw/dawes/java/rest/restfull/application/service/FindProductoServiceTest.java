/**
 * 
 * @author Nuhaila Assaid Aabdenour 
 */
package es.etg.daw.dawes.java.rest.restfull.application.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.producto.ProductoFactory;

@ExtendWith(MockitoExtension.class) // Extensión de Mockito
public class FindProductoServiceTest {

    //Lo que vamos a simular
    @Mock
    private FindProductoUseCase findProductosUseCase; 


    //Lo que vamos a probar y depende del mock
    @InjectMocks
    private FindProductoService findProductosServide; 
    

    @Test
    void findAll() {
        // Lo que vamos a simular: El caso de uso
        when(findProductosUseCase.findAll())
                .thenReturn(List.copyOf(ProductoFactory.getDemoData().values()));

        //Lo que vamos a probar
        var list = findProductosServide.findAll();

        // comprobaciones
        assertAll(
                () -> assertNotNull(list),
                () -> assertEquals(ProductoFactory.getDemoData().values().size(), list.size())
        );

        // verificamos que se ha llamado al método del caso de uso
        verify(findProductosUseCase, times(1))
                .findAll();
    }

}
