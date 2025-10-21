package anapicoli.agendamentos_api.controller;

import java.time.LocalDateTime;

public class AgendamentoDTO {
    private Long clienteId;
    private Long servicoId;
    private LocalDateTime dataAgendada;
    private String observacoes;
    private String status;

    // Getters e Setters
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getServicoId() {
        return servicoId;
    }
    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public LocalDateTime getDataAgendada() {
        return dataAgendada;
    }
    public void setDataAgendada(LocalDateTime dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}