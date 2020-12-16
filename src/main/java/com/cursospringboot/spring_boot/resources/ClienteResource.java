package com.cursospringboot.spring_boot.resources;

import com.cursospringboot.spring_boot.domain.Cliente;
import com.cursospringboot.spring_boot.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//CONTROLADOR REST

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
    @Autowired
    private ClienteService service;

    @RequestMapping (value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id){
        Cliente obj = service.buscar(id);
        return  ResponseEntity.ok().body(obj);




    }
}
