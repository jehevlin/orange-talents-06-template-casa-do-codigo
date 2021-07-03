package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Categoria;
import br.com.zupacademy.jessica.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarCategoriaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "categoria")
public class CategoriaController {
    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {this.repository = repository;}

    @PostMapping
    public ResponseEntity<?> cadastrarCategoria(@Valid @RequestBody CadastrarCategoriaRequest request){
        Categoria categoria = repository.save(request.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
