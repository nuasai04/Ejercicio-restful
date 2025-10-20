package es.etg.daw.dawes.java.rest.restfull.productos.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

//Esta clase tiene los datos necesarios para editar un Producto
@Getter
@Builder
@AllArgsConstructor
@Accessors(fluent = true) // Así los getters no llevan prefijo get
public class EditProductoCommand {
	
	private int id;
	private String nombre;
	private double precio;
}