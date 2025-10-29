package es.etg.daw.dawes.java.rest.restfull.common.infraestructure.web.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//Indicamos que es una gestora de errores
@RestControllerAdvice
public class GlobalExceptionHandler {


    
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<CustomResponse> nullPointerHandler(NullPointerException nfe) {
        String msg = nfe.getMessage();
		CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, msg);
		return new ResponseEntity<>(cr, cr.getStatus());
	}
}