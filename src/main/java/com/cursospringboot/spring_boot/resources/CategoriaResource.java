package com.cursospringboot.spring_boot.resources;

import com.cursospringboot.spring_boot.domain.Categoria;
import com.cursospringboot.spring_boot.services.CategoriaService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//CONTROLADOR REST

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService service;

    @RequestMapping (value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id){
        Categoria obj = service.buscar(id);
        return  ResponseEntity.ok().body(obj);




    }
}
