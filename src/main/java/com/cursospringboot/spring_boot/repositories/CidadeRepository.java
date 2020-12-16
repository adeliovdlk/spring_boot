package com.cursospringboot.spring_boot.repositories;


import com.cursospringboot.spring_boot.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//para realizar operacoes de acesso a dados referente ao obejeto cidade
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
