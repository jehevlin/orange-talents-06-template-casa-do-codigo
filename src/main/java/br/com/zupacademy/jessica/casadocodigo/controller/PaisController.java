package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Pais;
import br.com.zupacademy.jessica.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarPaisRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "paises")
public class PaisController {

    private final PaisRepository repository;

    public PaisController (PaisRepository repository) {this.repository = repository;}

    @PostMapping
    public ResponseEntity<?> cadastrarPais(@Valid @RequestBody CadastrarPaisRequest request) {
        Pais pais = repository.save(request.toModel());
        return new ResponseEntity<>(pais, HttpStatus.OK);
    }
}
