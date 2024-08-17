package com.ordem_servico.romero.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ordem_servico.romero.controller.entity.dto.OrdenServicoDTO;
import com.ordem_servico.romero.service.OrdenServicoService;

@RestController
@RequestMapping(value = "/api/ordens-servicos")
public class OrdenServicoController {

    @Autowired
    private OrdenServicoService service;
    
    @GetMapping
    public ResponseEntity<Page<OrdenServicoDTO>> findAll(Pageable pageable) {
    	Page<OrdenServicoDTO> page = service.findAll(pageable);
		return ResponseEntity.ok().body(page);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrdenServicoDTO> findById(@PathVariable Long id) {
    	OrdenServicoDTO dto = service.findById(id);
    	return ResponseEntity.ok().body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrdenServicoDTO> update(@RequestBody OrdenServicoDTO dto, @PathVariable Long id) {
    	OrdenServicoDTO newDto = service.update(id, dto);
    	return ResponseEntity.ok().body(newDto);
    }
    
    @PostMapping
    public ResponseEntity<OrdenServicoDTO> salvaOrdenServico(@RequestBody OrdenServicoDTO request){
        OrdenServicoDTO dto = service.salva(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    	service.delete(id);
		return ResponseEntity.noContent().build();
    }
}
