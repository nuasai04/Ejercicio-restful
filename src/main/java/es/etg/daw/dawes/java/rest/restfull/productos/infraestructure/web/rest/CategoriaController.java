package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.CreateCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.DeleteCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.EditCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.Categoria;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.model.CategoriaId;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.mapper.CategoriaMapper;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.web.dto.categoria.CategoriaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CreateCategoriaService createCategoriaService;
    private final FindCategoriaService findCategoriaService;
    private final DeleteCategoriaService deleteCategoriaService;
    private final EditCategoriaService editCategoriaService;

    @PostMapping // Método Post
    public ResponseEntity<CategoriaResponse> createProducto(@Valid @RequestBody CategoriaRequest categoriaRequest) {
        CreateCategoriaCommand comando = CategoriaMapper.toCommand(categoriaRequest);
        Categoria categoria = createCategoriaService.createCategoria(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaMapper.toResponse(categoria)); // Respuestagit@github.com:julparper/dawes-springboot-restful.git
    }

    // Recogemos la versión el properties
    @Value("${api.version}")
    private String apiVersion;

    @GetMapping 
    public List<CategoriaResponse> allProductos() {
        //if(true) throw new NullPointerException();
        if ("1.0".equals(apiVersion)) {
            return findCategoriaService.findAll()
                    .stream() // Convierte la lista en un flujo
                    .map(CategoriaMapper::toResponse) // Mapeamos/Convertimos cada elemento del flujo (Producto) en un
                                                     // objeto de Respuesta (ProductoResponse)
                    .toList(); // Lo devuelve como una lista.
        } else {
            // Lanzamos una excepción con el error
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Versión del API incorrecta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable int id) {
        deleteCategoriaService.delete(new CategoriaId(id));
        return ResponseEntity.noContent().build(); // Devpñvemos una respuesta vacía.
    }

    @PutMapping("/{id}")
    public CategoriaResponse editCategoria(@PathVariable int id, @RequestBody CategoriaRequest categoriaRequest) {
        EditCategoriaCommand comando = CategoriaMapper.toCommand(id, categoriaRequest);
        Categoria categoria = editCategoriaService.update(comando);
        return CategoriaMapper.toResponse(categoria); // Respuesta
    }

    // Método que captura los errores y devuelve un mapa con el campo que no cumple
    // la validación y un mensaje de error.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
