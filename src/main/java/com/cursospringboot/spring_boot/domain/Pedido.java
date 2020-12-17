package com.cursospringboot.spring_boot.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Pedido implements Serializable {
    public static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "pedido")//mapeamento bidirecional um para um garantindo que o id do pagamento e mesmo id do pedido referente a ele
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name ="cliente_id" )  //nome da chave estrangeira
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;

    public Pedido() {
    }

    public Pedido(Long id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {//removido o pagamento do construtor
        this.id = id;
        this.instante = instante;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return id != null ? id.equals(pedido.id) : pedido.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
