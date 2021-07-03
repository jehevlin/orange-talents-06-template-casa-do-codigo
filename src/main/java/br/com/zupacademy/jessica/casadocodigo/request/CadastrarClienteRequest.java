package br.com.zupacademy.jessica.casadocodigo.request;

import br.com.zupacademy.jessica.casadocodigo.model.Cliente;
import br.com.zupacademy.jessica.casadocodigo.model.Estado;
import br.com.zupacademy.jessica.casadocodigo.model.Pais;
import br.com.zupacademy.jessica.casadocodigo.request.validator.EstadoObrigatorioQuandoPaisPossuiEstado;
import br.com.zupacademy.jessica.casadocodigo.request.validator.MustBeUnique;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoObrigatorioQuandoPaisPossuiEstado
public class CadastrarClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @CPF
    @MustBeUnique(domainClass = Cliente.class, fieldName = "cpf", message = "CPF já cadastrado")
    private String cpf;

    @NotBlank
    @Email
    @MustBeUnique(domainClass = Cliente.class, fieldName = "email", message = "Email já cadastrado")
    private String email;

    @NotNull
    private long telefone;

    @NotNull
    private int cep;

    @NotNull
    private Pais pais;

    private Estado estado; //caso o pais tenha estado

    @NotBlank
    private String cidade;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public long getTelefone() {
        return telefone;
    }

    public int getCep() {
        return cep;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public Cliente toModel() {
        return new Cliente(nome, sobrenome, cpf, email, telefone, cep, pais, estado, cidade, endereco, complemento);
    }
}

//se o país tiver estados, um estado precisa ser selecionado
//estado(caso aquele pais tenha estado) - apenas se o país tiver cadastro de estados