package br.com.treinaweb.hyperprof.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.hyperprof.core.models.TokenInvalido;

public interface TokenInvalidoRepository extends JpaRepository<TokenInvalido, Long> {

    boolean existsByToken(String token);

}
