package br.com.zupacademy.jessica.casadocodigo.request;

import br.com.zupacademy.jessica.casadocodigo.model.Estado;
import br.com.zupacademy.jessica.casadocodigo.model.Pais;
import br.com.zupacademy.jessica.casadocodigo.request.validator.EstadoUnicoPorPais;

import javax.validation.constraints.NotBlank;

@EstadoUnicoPorPais
public class CadastrarEstadoRequest {

    @NotBlank
    private String nome;

    private Pais pais;

    public Estado toModel() { return new Estado(nome, pais); }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
