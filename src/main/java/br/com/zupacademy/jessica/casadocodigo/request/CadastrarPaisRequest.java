package br.com.zupacademy.jessica.casadocodigo.request;

import br.com.zupacademy.jessica.casadocodigo.model.Pais;
import br.com.zupacademy.jessica.casadocodigo.request.validator.MustBeUnique;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CadastrarPaisRequest {

    @Id
    @NotBlank
    @MustBeUnique(domainClass = Pais.class, fieldName = "nome", message = "país já cadastrado")
    private String nome;

    public Pais toModel() { return new Pais(nome); }

    public String getNome() { return nome; }
}
