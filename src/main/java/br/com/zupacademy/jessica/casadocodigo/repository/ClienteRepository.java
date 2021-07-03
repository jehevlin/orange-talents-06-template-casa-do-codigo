package br.com.zupacademy.jessica.casadocodigo.repository;

import br.com.zupacademy.jessica.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
