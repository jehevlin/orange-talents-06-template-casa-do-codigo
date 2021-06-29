package br.com.zupacademy.jessica.casadocodigo.request;

import br.com.zupacademy.jessica.casadocodigo.model.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastrarAutorRequest {
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank
    @Email(message = "Email é obrigatório e preicisa ser válido!")
    private String email;

    @NotBlank (message = "Descrição é obrigatória!")
    @Size(max = 400)
    private String descricao;

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
