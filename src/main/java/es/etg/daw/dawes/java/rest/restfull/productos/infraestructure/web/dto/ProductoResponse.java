package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.ProductoId;

public record ProductoResponse(ProductoId id, String nombre, double precio, LocalDateTime createdAt) {
	
}