package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Livro;
import br.com.zupacademy.jessica.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarLivroRequest;
import br.com.zupacademy.jessica.casadocodigo.response.LivroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "livro")
@Transactional
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@Valid @RequestBody CadastrarLivroRequest request){
        Livro livro = repository.save(request.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listarLivros(){
        List<LivroResponse> livros = new ArrayList<>();
        for (Livro livro : repository.findAll()) {
            livros.add(new LivroResponse(livro.getId(), livro.getTitulo()));
        }
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }
}
