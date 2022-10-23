package br.com.treinaweb.hyperprof.api.auth.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import br.com.treinaweb.hyperprof.api.auth.dtos.LoginRequest;
import br.com.treinaweb.hyperprof.api.auth.dtos.LoginResponse;
import br.com.treinaweb.hyperprof.core.models.AuthenticatedUser;
import br.com.treinaweb.hyperprof.core.services.token.TokenService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            loginRequest.getEmail(),
            loginRequest.getPassword()
        );
        var authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var professor = ((AuthenticatedUser) authentication.getPrincipal()).getProfessor();
        return LoginResponse.builder()
            .token(tokenService.gerarAccessToken(professor.getEmail()))
            .refreshToken(tokenService.gerarRefreshToken(professor.getEmail()))
            .build();
    }

}
