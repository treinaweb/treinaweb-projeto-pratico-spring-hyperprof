package br.com.treinaweb.hyperprof.core.services.token.providers.jjwt;

import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.core.services.token.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JjwtTokenService implements TokenService {

    private final JjwtConfigProperties configProperties;

    @Override
    public String gerarAccessToken(String subject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSubjectDoAccessToken(String accessToken) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String gerarRefreshToken(String subject) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSubjectDoRefreshToken(String refreshToken) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void invalidarTokens(String... tokens) {
        // TODO Auto-generated method stub

    }

}
