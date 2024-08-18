package com.ordem_servico.romero.controller.entity.dto;

import java.io.Serializable;

import com.ordem_servico.romero.controller.entity.OrdenServico;
import jakarta.validation.constraints.NotEmpty;

public class OrdenServicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    private String descricao;

    @NotEmpty
    private String solicitante;

    public OrdenServicoDTO() {
    }

    public OrdenServicoDTO(Long id, String descricao, String solicitante) {
        this.id = id;
        this.descricao = descricao;
        this.solicitante = solicitante;
    }

    public OrdenServicoDTO(OrdenServico ordenServico) {
        this.id = ordenServico.getId();
        this.descricao = ordenServico.getDescricao();
        this.solicitante = ordenServico.getSolicitante();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
}
