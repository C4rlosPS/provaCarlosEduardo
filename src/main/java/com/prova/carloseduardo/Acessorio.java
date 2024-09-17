package com.prova.carloseduardo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Acessorio {

    @Id
    @GeneratedValue
    private Long id;
    private Integer veiculoId;
    private String nome;

    public Acessorio(Integer veiculoId, String nome) {
        this.veiculoId = veiculoId;
        this.nome = nome;
    }

    public Acessorio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acessorio)) return false;
        Acessorio acessorio = (Acessorio) o;
        return Objects.equals(this.id, acessorio.id)
                && Objects.equals(this.veiculoId, acessorio.veiculoId)
                && Objects.equals(this.nome, acessorio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.veiculoId, this.nome);
    }

    @Override
    public String toString() {
        return "Acessorio{" +
                "id=" + id +
                ", veiculoId=" + veiculoId +
                ", nome='" + nome + '\'' +
                '}';
    }
}