package com.cursospringboot.spring_boot.repositories;


import com.cursospringboot.spring_boot.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//para realizar operacoes de acesso a dados referente ao obejeto categoria
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
