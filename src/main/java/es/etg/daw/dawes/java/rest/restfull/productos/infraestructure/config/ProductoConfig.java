package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

    private final ProductoRepository productoRepository;

    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase(productoRepository);
    }

    @Bean
    public CreateProductoService createProductoService() {
        return new CreateProductoService(createProductoUseCase());
    }

    @Bean
    public FindProductoUseCase findProductoUseCase() {
        return new FindProductoUseCase(productoRepository);
    }

    @Bean
    public FindProductoService findProductoService() {
        return new FindProductoService(findProductoUseCase());
    }

    @Bean
    public DeleteProductoUseCase deleteProductoUseCase() {
        return new DeleteProductoUseCase(productoRepository);
    }

    @Bean
    public DeleteProductoService deleteProductoService() {
        return new DeleteProductoService(deleteProductoUseCase());
    }

    @Bean
    public EditProductoUseCase editProductoUseCase() {
        return new EditProductoUseCase(productoRepository);
    }

    @Bean
    public EditProductoService editProductoService() {
        return new EditProductoService(editProductoUseCase());
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    

}