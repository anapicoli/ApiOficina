package anapicoli.agendamentos_api.repository;

import anapicoli.agendamentos_api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {}