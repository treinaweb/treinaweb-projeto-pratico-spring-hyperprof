package br.com.treinaweb.hyperprof.api.auth.services;

import br.com.treinaweb.hyperprof.api.auth.dtos.LoginRequest;
import br.com.treinaweb.hyperprof.api.auth.dtos.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

}
