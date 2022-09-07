package br.com.tage.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tage.core.model.AlunoFacul;

public interface AlunoFaculRepository extends JpaRepository<AlunoFacul, Integer> {
  List<AlunoFacul> findByNomeAlunoContainsIgnoreCase(String nome);
}
