package anapicoli.agendamentos_api.repository;

import anapicoli.agendamentos_api.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {}