package com.cursospringboot.spring_boot.domain;

import com.cursospringboot.spring_boot.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  //para mapear uma heranca foi escolhido uma tabela para cada
public abstract class Pagamento implements Serializable {
    public static final long serialVersionUID=1L;
    @Id
    //nesse caso nao vai  a anotacao @GeneratedValue(strategy = GenerationType.IDENTITY) que serve para gerar automaticamente pois o pagamento tem q ter o id dele igual ao do Pedido
    private Long id;
    private Integer estado; //EstadoPagamento estado; //adaptacao

    //@JsonBackReference
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Long id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado.getCod();//adaptado
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;

        return id != null ? id.equals(pagamento.id) : pagamento.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado); //adaptado
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod(); //adaptado
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
