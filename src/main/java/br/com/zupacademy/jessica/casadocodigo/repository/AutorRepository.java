package br.com.zupacademy.jessica.casadocodigo.repository;

import br.com.zupacademy.jessica.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
