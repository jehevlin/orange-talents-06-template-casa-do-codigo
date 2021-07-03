package br.com.zupacademy.jessica.casadocodigo.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private long telefone;

    @NotNull
    private int cep;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado; //caso o pais tenha estado

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @Deprecated
    public Cliente() {}

    public Cliente(String nome, String sobrenome, String cpf, String email, long telefone, int cep,
                   Pais pais, Estado estado, String cidade, String endereco, String complemento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.endereco = endereco;
        this.complemento = complemento;
    }
}


//se o país tiver estados, um estado precisa ser selecionado
//estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados
