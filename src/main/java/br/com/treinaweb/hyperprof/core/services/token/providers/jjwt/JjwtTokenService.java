package br.com.treinaweb.hyperprof.core.services.token.providers.jjwt;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.core.models.TokenInvalido;
import br.com.treinaweb.hyperprof.core.repositories.TokenInvalidoRepository;
import br.com.treinaweb.hyperprof.core.services.token.TokenService;
import br.com.treinaweb.hyperprof.core.services.token.TokenServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JjwtTokenService implements TokenService {

    private final JjwtConfigProperties configProperties;
    private final TokenInvalidoRepository tokenInvalidoRepository;

    @Override
    public String gerarAccessToken(String subject) {
        return gerarToken(
            subject,
            configProperties.getAccessTokenExpirationInSeconds(),
            configProperties.getAccessTokenSigingKey()
        );
    }

    @Override
    public String getSubjectDoAccessToken(String accessToken) {
        return getClaims(accessToken, configProperties.getAccessTokenSigingKey()).getSubject();
    }

    @Override
    public String gerarRefreshToken(String subject) {
        return gerarToken(
            subject,
            configProperties.getRefreshTokenExpirationInSeconds(),
            configProperties.getRefreshTokenSigingKey()
        );
    }

    @Override
    public String getSubjectDoRefreshToken(String refreshToken) {
        return getClaims(refreshToken, configProperties.getRefreshTokenSigingKey()).getSubject();
    }

    @Override
    public void invalidarTokens(String... tokens) {
        var tokensInvalidos = Stream.of(tokens)
            .map(token -> TokenInvalido.builder().token(token).build())
            .toList();
        tokenInvalidoRepository.saveAll(tokensInvalidos);
    }

    private String gerarToken(String subject, Long expirationInSeconds, String siginKey) {
        var dataHoraAtual = Instant.now();
        var dataHoraExpiracao = dataHoraAtual.plusSeconds(expirationInSeconds);
        return Jwts.builder()
            .setClaims(new HashMap<String, Object>())
            .setSubject(subject)
            .setIssuedAt(Date.from(dataHoraAtual))
            .setExpiration(Date.from(dataHoraExpiracao))
            .signWith(Keys.hmacShaKeyFor(siginKey.getBytes()))
            .compact();
    }

    private Claims getClaims(String token, String sigingKey) {
        try {
            return tryGetClaims(token, sigingKey);
        } catch (JwtException e) {
            throw new TokenServiceException(e.getLocalizedMessage());
        }
    }

    private Claims tryGetClaims(String token, String sigingKey) {
        if (tokenInvalidoRepository.existsByToken(token)) {
            throw new TokenServiceException("Token inválido");
        }
        return Jwts.parserBuilder()
            .setSigningKey(Keys.hmacShaKeyFor(sigingKey.getBytes()))
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

}
