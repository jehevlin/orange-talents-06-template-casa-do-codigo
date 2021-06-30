package br.com.zupacademy.jessica.casadocodigo.repository;

import br.com.zupacademy.jessica.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
