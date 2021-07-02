package br.com.zupacademy.jessica.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @NotBlank
    private String nome;

    public String getNome() { return nome; }

    public Pais(String nome) { this.nome = nome;}

    @Deprecated
    public Pais(){ }
}
