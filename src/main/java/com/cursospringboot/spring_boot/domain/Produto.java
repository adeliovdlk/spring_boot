package com.cursospringboot.spring_boot.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
@Entity
public class Produto implements Serializable {
    public static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  Double preco;
//ver se vai get set categorias
    @ManyToMany
    @JoinTable  (name = "PRODUTO_CATEGORIA",
        joinColumns = @JoinColumn(name = "produto_d"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id" )
    )
    private List<Categoria> categorias= new ArrayList<>();

    public Produto() {

    }

    public Produto(Long id, String name, Double preco) {
        this.id = id;
        this.name = name;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id != null ? id.equals(produto.id) : produto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

