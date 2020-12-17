package com.cursospringboot.spring_boot.repositories;

import com.cursospringboot.spring_boot.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
