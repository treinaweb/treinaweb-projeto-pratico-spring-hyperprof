package br.com.treinaweb.hyperprof.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.hyperprof.core.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
