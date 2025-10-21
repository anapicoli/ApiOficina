package anapicoli.agendamentos_api.controller;

import anapicoli.agendamentos_api.model.Agendamento;
import anapicoli.agendamentos_api.model.Cliente;
import anapicoli.agendamentos_api.model.Servico;
import anapicoli.agendamentos_api.repository.AgendamentoRepository;
import anapicoli.agendamentos_api.repository.ClienteRepository;
import anapicoli.agendamentos_api.repository.ServicoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    private final AgendamentoRepository agendamentoRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;

    public AgendamentoController(AgendamentoRepository agendamentoRepository,
                                 ClienteRepository clienteRepository,
                                 ServicoRepository servicoRepository) {
        this.agendamentoRepository = agendamentoRepository;
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
    }

    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Agendamento getAgendamento(@PathVariable Long id) {
        return agendamentoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody AgendamentoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow();
        Servico servico = servicoRepository.findById(dto.getServicoId()).orElseThrow();

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataAgendada(dto.getDataAgendada());
        agendamento.setObservacoes(dto.getObservacoes());

        return agendamentoRepository.save(agendamento);
    }

    @PutMapping("/{id}")
    public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoDTO dto) {
        Agendamento agendamento = agendamentoRepository.findById(id).orElseThrow();

        if(dto.getDataAgendada() != null)
            agendamento.setDataAgendada(dto.getDataAgendada());
        if(dto.getStatus() != null)
            agendamento.setStatus(dto.getStatus());

        return agendamentoRepository.save(agendamento);
    }

    @DeleteMapping("/{id}")
    public void deletarAgendamento(@PathVariable Long id) {
        agendamentoRepository.deleteById(id);
    }
}