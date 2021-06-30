package br.com.zupacademy.jessica.casadocodigo.repository;

import br.com.zupacademy.jessica.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
