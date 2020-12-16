package com.cursospringboot.spring_boot.services;

import com.cursospringboot.spring_boot.domain.Cliente;
import com.cursospringboot.spring_boot.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Long id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElse(null);
    }

}
