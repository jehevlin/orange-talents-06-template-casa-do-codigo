package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Estado;
import br.com.zupacademy.jessica.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarEstadoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "estados")
public class EstadoController {

    private final EstadoRepository repository;

    public EstadoController (EstadoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@Valid @RequestBody CadastrarEstadoRequest request) {
        Estado estado = repository.save(request.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
