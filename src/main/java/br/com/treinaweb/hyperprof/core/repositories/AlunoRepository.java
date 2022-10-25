package br.com.treinaweb.hyperprof.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.hyperprof.core.models.Aluno;
import br.com.treinaweb.hyperprof.core.models.Professor;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByProfessor(Professor professor);

}
