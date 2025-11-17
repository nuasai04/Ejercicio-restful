package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.CreateProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.producto.EditProductoCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Producto;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto.ProductoRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.producto.ProductoResponse;

public class ProductoMapper {

	public static CreateProductoCommand toCommand(ProductoRequest productoRequest){
		return new CreateProductoCommand(productoRequest.nombre(), productoRequest.precio(), new CategoriaId(productoRequest.categoria()));
	}

	public static ProductoResponse toResponse(Producto producto){
		return new ProductoResponse(producto.getId().getValue(),
									producto.getNombre(),
									producto.getPrecio(),
									producto.getCreatedAt(),
									producto.getCategoriaId().getValue());
	}

	public static EditProductoCommand toCommand(int id, ProductoRequest productoRequest){
		return new EditProductoCommand(new ProductoId(id), productoRequest.nombre(), productoRequest.precio());
	}
	
}