package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.ProductoMapper;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final CreateProductoService createProductoService;
    private final FindProductoService findProductoService;
    private final DeleteProductoService deleteProductoService;
    private final EditProductoService editProductoService;

    @PostMapping // Método Post
    public ResponseEntity<ProductoResponse> createProducto(@RequestBody ProductoRequest productoRequest) {
        CreateProductoCommand comando = ProductoMapper.toCommand(productoRequest);
        Producto producto = createProductoService.createProducto(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductoMapper.toResponse(producto)); // Respuestagit@github.com:julparper/dawes-springboot-restful.git
    }

    @GetMapping
    public List<ProductoResponse> allProductos() {

        return findProductoService.findAll()
                .stream() // Convierte la lista en un flujo
                .map(ProductoMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un objeto
                                                 // de Respuesta (ProductoResponse)
                .toList(); // Lo devuelve como una lista.

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id) {
        deleteProductoService.delete(id);
        return ResponseEntity.noContent().build(); // Devpñvemos una respuesta vacía.
    }

     @PutMapping("/{id}")
    public ProductoResponse editProducto(@PathVariable int id, @RequestBody ProductoRequest productoRequest){
        EditProductoCommand comando = ProductoMapper.toCommand(id, productoRequest);
        Producto producto = editProductoService.update(comando);
        return  ProductoMapper.toResponse(producto); //Respuesta
    }
}