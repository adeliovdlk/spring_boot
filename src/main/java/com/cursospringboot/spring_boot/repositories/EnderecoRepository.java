package com.cursospringboot.spring_boot.repositories;



import com.cursospringboot.spring_boot.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//para realizar operacoes de acesso a dados referente ao obejeto
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
