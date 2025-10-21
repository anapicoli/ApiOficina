package anapicoli.agendamentos_api.repository;

import anapicoli.agendamentos_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}