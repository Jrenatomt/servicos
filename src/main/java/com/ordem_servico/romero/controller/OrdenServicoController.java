package com.ordem_servico.romero.controller;

import com.ordem_servico.romero.controller.entity.dto.OrdenServicoDTO;
import com.ordem_servico.romero.service.OrdenServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ordens-servicos")
public class OrdenServicoController {

    @Autowired
    private OrdenServicoService service;

    @PostMapping
    public ResponseEntity<OrdenServicoDTO> salvaOrdenServico(@RequestBody OrdenServicoDTO request){
        OrdenServicoDTO dto = service.salva(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
