package br.com.treinaweb.hyperprof.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.hyperprof.core.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
