package com.cursospringboot.spring_boot.repositories;

import com.cursospringboot.spring_boot.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//para realizar operacoes de acesso a dados referente ao obejeto estado
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
