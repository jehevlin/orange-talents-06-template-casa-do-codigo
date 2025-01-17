package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Livro;
import br.com.zupacademy.jessica.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarLivroRequest;
import br.com.zupacademy.jessica.casadocodigo.response.DetalheLivroResponse;
import br.com.zupacademy.jessica.casadocodigo.response.LivroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> detalhe(@PathVariable("id") Long id){
        Optional<Livro> opitional = repository.findById(id);
        if (opitional.isPresent()){
            Livro livro = opitional.get();
            return new ResponseEntity<>(new DetalheLivroResponse(livro.getId(), livro.getTitulo(),
                    livro.getResumo(), livro.getAutor().getNome(), livro.getAutor().getDescricao(),
                    livro.getPreco(), livro.getSumario(), livro.getPaginas(), livro.getIsbn()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
