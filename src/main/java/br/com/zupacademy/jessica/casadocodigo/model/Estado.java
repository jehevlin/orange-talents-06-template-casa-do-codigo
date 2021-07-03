package br.com.zupacademy.jessica.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado(){ }

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public long getId() {
        return id;
    }
}
