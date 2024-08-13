package com.ordem_servico.romero.service;

import com.ordem_servico.romero.controller.entity.OrdenServico;
import com.ordem_servico.romero.controller.entity.dto.OrdenServicoDTO;
import com.ordem_servico.romero.repository.OrdenServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenServicoService {

    @Autowired
    private OrdenServicoRepository repository;

    public OrdenServicoDTO salva(OrdenServicoDTO dto) {
        OrdenServico ordenServico = new OrdenServico();
        ordenServico.setSolicitante(dto.getSolicitante());
        ordenServico.setDescricao(dto.getDescricao());
        ordenServico = repository.save(ordenServico);
        return new OrdenServicoDTO(ordenServico);
    }

}
