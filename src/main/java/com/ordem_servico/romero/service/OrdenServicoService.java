package com.ordem_servico.romero.service;


import com.ordem_servico.romero.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ordem_servico.romero.controller.entity.OrdenServico;
import com.ordem_servico.romero.controller.entity.dto.OrdenServicoDTO;
import com.ordem_servico.romero.repository.OrdenServicoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdenServicoService {

    @Autowired
    private OrdenServicoRepository repository;

	@Transactional(readOnly = true)
    public Page<OrdenServicoDTO> findAll(Pageable pageable) {
    	Page<OrdenServico> list = repository.findAll(pageable);
    	return list.map(OrdenServicoDTO::new);
    }

	@Transactional(readOnly = true)
    public OrdenServicoDTO findById(Long id) {
    	OrdenServico entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Ordem de seviço não encontrada"));
		return new OrdenServicoDTO(entity);
    }

	@Transactional
    public OrdenServicoDTO update(Long id, OrdenServicoDTO dto) {
    	OrdenServico entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new OrdenServicoDTO(entity);
	}

	@Transactional
	public OrdenServicoDTO salva(OrdenServicoDTO dto) {
        OrdenServico ordenServico = new OrdenServico();
        fromDto(dto, ordenServico);
        ordenServico = repository.save(ordenServico);
        return new OrdenServicoDTO(ordenServico);
    }

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void fromDto(OrdenServicoDTO dto, OrdenServico entity) {
		entity.setSolicitante(dto.getSolicitante());
		entity.setDescricao(dto.getDescricao());
	}
}
