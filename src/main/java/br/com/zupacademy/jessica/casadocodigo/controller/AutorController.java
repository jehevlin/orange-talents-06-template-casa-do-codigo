package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Autor;
import br.com.zupacademy.jessica.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarAutorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "autor")
public class AutorController {

    private AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAutor (@Valid @RequestBody CadastrarAutorRequest request) {
        Autor autor = repository.save(request.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
