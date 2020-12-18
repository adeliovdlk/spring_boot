package com.cursospringboot.spring_boot.services;

import com.cursospringboot.spring_boot.domain.Pedido;
import com.cursospringboot.spring_boot.repositories.CategoriaRepository;
import com.cursospringboot.spring_boot.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Long id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
