package com.labanta.servidorlocal.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ServicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private Double preco;
    private Boolean estaAtivo;
    private Double precoComDesconto;

    public ServicoModel() {}

    public ServicoModel(String novoTitulo, String novoDiscricao, Double novoPreco, Boolean novoEstaAtivo, Double novoPrecoComDesconto) {
        this.titulo = novoTitulo;
        this.descricao = novoDiscricao;
        this.preco = novoPreco;
        this.estaAtivo = novoEstaAtivo;
        this.precoComDesconto = novoPrecoComDesconto;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }
    public String getTitulo() {
        return this.titulo;

    }
    public void setDescricao( String descricao) {
        this.descricao = descricao;

    }
    public String getDescricao() {
        return this.descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public double getPreco() {
        return this.preco;
    }

    public void setEstaAtivo (boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }
    public boolean getEstaAtivo() {
        return this.estaAtivo;
    }

    public void setPrecoComDesconto(Double precoComDesconto) { this.precoComDesconto = precoComDesconto; }
    public Double getPrecoComDesconto() {return this.precoComDesconto;}
}
