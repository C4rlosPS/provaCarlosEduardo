package com.prova.carloseduardo;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class Acessorio {

    @ManyToOne
    @JoinColumn(name="veiculo_id", nullable=false)
    private Veiculo veiculo;

    private @Id
    @GeneratedValue Long id;
    private String nome;

    public Acessorio(){}

    public Acessorio(String nome, Veiculo veiculo) {
        this.nome = nome;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Acessorio))
            return false;
        Acessorio acessorio = (Acessorio) o;
        return Objects.equals(this.id, acessorio.id) && Objects.equals(this.nome, acessorio.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nome);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + this.id + ", name='" + this.nome + '}';
    }


}
