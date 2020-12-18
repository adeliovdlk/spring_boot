package com.cursospringboot.spring_boot.services;

import com.cursospringboot.spring_boot.domain.Categoria;
import com.cursospringboot.spring_boot.repositories.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

   /* public Categoria buscar(Long id) {
        Optional<Categoria> obj = repo.findById(id);
        if(obj==null){
            throw new ObjectNotFoundException("objeto nao encontrado ! :" + id
                    + ", tipo :"+ Categoria.class.getName());
        }
        return obj.orElse(null);
    }*/
    public Categoria buscar(Long id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

}
