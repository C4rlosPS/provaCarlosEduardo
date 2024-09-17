package com.prova.carloseduardo;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Veiculo {

    private @Id
    @GeneratedValue Long id;
    private String modelo;
    private String placa;
    private Integer ano;
    @OneToMany(mappedBy="veiculo")
    private List<Acessorio> acessorios;
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

        if (this == o)
            return true;
        if (!(o instanceof Veiculo))
            return false;
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
        return "Veiculo" +
                "{" + "id=" + this.id
                + ", modelo='" + this.modelo + '\''
                + ", placa='" + this.placa + '\''
                + ", ano='" + this.ano + '\''
                + ", acessorio='" + this.acessorios + '\''
                + '}';
    }



}
