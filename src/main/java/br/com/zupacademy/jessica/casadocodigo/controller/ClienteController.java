package br.com.zupacademy.jessica.casadocodigo.controller;

import br.com.zupacademy.jessica.casadocodigo.model.Cliente;
import br.com.zupacademy.jessica.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.jessica.casadocodigo.request.CadastrarClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {

    private ClienteRepository repository;

    private ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<?> CadastrarCliente (@Valid @RequestBody CadastrarClienteRequest request) {
        Cliente cliente = repository.save(request.toModel());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}