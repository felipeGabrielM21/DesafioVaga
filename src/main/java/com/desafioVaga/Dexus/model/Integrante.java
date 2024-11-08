package com.desafioVaga.Dexus.model;

import com.desafioVaga.Dexus.dtos.FiltrarIntrgrante;
import com.desafioVaga.Dexus.dtos.IntegranteDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "integrante")
@EqualsAndHashCode(of = "id")
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String franquia;
    private String nome;
    private String funcao;

    public Integrante(IntegranteDTO dados) {
        this.franquia = dados.franquia();
        this.nome = dados.nome();
        this.funcao = dados.funcao();
    }

    public Integrante(FiltrarIntrgrante dados) {

        this.funcao = dados.funcao();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFranquia() {
        return franquia;
    }

    public void setFranquia(String franquia) {
        this.franquia = franquia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
