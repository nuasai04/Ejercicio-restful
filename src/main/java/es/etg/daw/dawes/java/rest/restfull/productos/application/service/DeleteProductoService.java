package es.etg.daw.dawes.java.rest.restfull.productos.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class DeleteProductoService {
    

    private final DeleteProductoUseCase deleteProductoUseCase;


    public void delete(int id){
        deleteProductoUseCase.delete(id);
    }
}
