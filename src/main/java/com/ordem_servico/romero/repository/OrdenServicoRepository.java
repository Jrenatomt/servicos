package com.ordem_servico.romero.repository;

import com.ordem_servico.romero.controller.entity.OrdenServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenServicoRepository extends JpaRepository<OrdenServico, Long> {
}
