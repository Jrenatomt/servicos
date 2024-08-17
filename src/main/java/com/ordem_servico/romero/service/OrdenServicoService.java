package com.ordem_servico.romero.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ordem_servico.romero.controller.entity.OrdenServico;
import com.ordem_servico.romero.controller.entity.dto.OrdenServicoDTO;
import com.ordem_servico.romero.repository.OrdenServicoRepository;

@Service
public class OrdenServicoService {

    @Autowired
    private OrdenServicoRepository repository;
    
    public Page<OrdenServicoDTO> findAll(Pageable pageable) {
    	Page<OrdenServico> list = repository.findAll(pageable);
    	return list.map(x -> new OrdenServicoDTO(x));
    }

    public OrdenServicoDTO findById(Long id) {
    	Optional<OrdenServico> entity = repository.findById(id);
    	return new OrdenServicoDTO(entity.get());
    }
    
    public OrdenServicoDTO update(Long id, OrdenServicoDTO dto) {
    	OrdenServico entity = repository.getReferenceById(id);
		fromDto(dto, entity);
		entity = repository.save(entity);
		return new OrdenServicoDTO(entity);
	}
    
	public OrdenServicoDTO salva(OrdenServicoDTO dto) {
        OrdenServico ordenServico = new OrdenServico();
        fromDto(dto, ordenServico);
        ordenServico = repository.save(ordenServico);
        return new OrdenServicoDTO(ordenServico);
    }
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	private void fromDto(OrdenServicoDTO dto, OrdenServico entity) {
		entity.setSolicitante(dto.getSolicitante());
		entity.setDescricao(dto.getDescricao());
	}
}
