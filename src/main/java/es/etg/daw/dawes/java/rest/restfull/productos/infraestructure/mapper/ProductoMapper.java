package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.ProductoResponse;

public class ProductoMapper {

	public static CreateProductoCommand toCommand(ProductoRequest productoRequest){
		return new CreateProductoCommand(productoRequest.nombre(), productoRequest.precio());
	}

	public static ProductoResponse toResponse(Producto producto){
		return new ProductoResponse(producto.getId(),
									producto.getNombre(),
									producto.getPrecio(),
									producto.getCreatedAt());
	}

	public static EditProductoCommand toCommand(int id, ProductoRequest productoRequest){
		return new EditProductoCommand(id, productoRequest.nombre(), productoRequest.precio());
	}
	
}