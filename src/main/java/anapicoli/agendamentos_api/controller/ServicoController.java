package anapicoli.agendamentos_api.controller;

import anapicoli.agendamentos_api.model.Servico;
import anapicoli.agendamentos_api.repository.ServicoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    private final ServicoRepository servicoRepository;

    public ServicoController(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    @PostMapping
    public Servico criarServico(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }
}