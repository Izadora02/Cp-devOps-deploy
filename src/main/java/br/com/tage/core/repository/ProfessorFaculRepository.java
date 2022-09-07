package br.com.tage.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tage.core.model.ProfessorFacul;

public interface ProfessorFaculRepository extends JpaRepository<ProfessorFacul, Integer> {
  List<ProfessorFacul> findByNomeProfContainsIgnoreCase(String nome);
}
