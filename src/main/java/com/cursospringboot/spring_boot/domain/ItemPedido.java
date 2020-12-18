package com.cursospringboot.spring_boot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;


@Entity
public class ItemPedido implements Serializable {
    public static final long serialVersionUID=1L;
    //chave composta contendo o produto e o pedido
    @JsonIgnore // nao permite q seja serializado  nem o pedido nem o produto
    @EmbeddedId  //id embutido em um tipo auxiliar
    private ItemPedidoPK id=new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private double preco;

    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido ,Produto produto, Double desconto, Integer quantidade, double preco) {

        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    @JsonIgnore
    public Pedido getPedido(){
        return id.getPedido();
    }
    //@JsonIgnore
    public Produto getProduto(){
        return id.getProduto();
    }

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemPedido that = (ItemPedido) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
