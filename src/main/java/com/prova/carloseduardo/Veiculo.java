package com.prova.carloseduardo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue
    private Long id;
    private String modelo;
    private String placa;
    private Integer ano;

    public Veiculo(String modelo, String placa, Integer ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public Veiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(this.id, veiculo.id)
                && Objects.equals(this.modelo, veiculo.modelo)
                && Objects.equals(this.placa, veiculo.placa)
                && Objects.equals(this.ano, veiculo.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.modelo, this.placa, this.ano);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", ano=" + ano +
                '}';
    }
}