/**
 * 
 * @author Nuhaila Assaid Aabdenour 
 */
package es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.AllArgsConstructor;

/*import es.etg.daw.dawes.java.rest.restfull.productos.application.service.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
*/

@AllArgsConstructor
public class DeleteProductoUseCase {

        private ProductoRepository productoRespository;

        public void delete(ProductoId id) {
                productoRespository.deteteById(id);
        }
}

