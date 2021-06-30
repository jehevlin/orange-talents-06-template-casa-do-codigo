package br.com.zupacademy.jessica.casadocodigo.request;

import br.com.zupacademy.jessica.casadocodigo.model.Categoria;
import br.com.zupacademy.jessica.casadocodigo.request.validator.MustBeUnique;

import javax.validation.constraints.NotBlank;

public class CadastrarCategoriaRequest {

    @NotBlank
    @MustBeUnique(domainClass = Categoria.class, fieldName = "nome", message = "Nome da categoria já cadastrado")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel(){ return new Categoria(nome);}
}
