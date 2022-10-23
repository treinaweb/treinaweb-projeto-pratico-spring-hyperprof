package br.com.treinaweb.hyperprof.api.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinaweb.hyperprof.api.auth.dtos.LoginRequest;
import br.com.treinaweb.hyperprof.api.auth.dtos.LoginResponse;
import br.com.treinaweb.hyperprof.api.auth.dtos.RefreshRequest;
import br.com.treinaweb.hyperprof.api.auth.services.AuthService;
import br.com.treinaweb.hyperprof.api.common.routes.ApiRoutes;
import br.com.treinaweb.hyperprof.api.common.utils.JwtBearerDefaults;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthRestController {

    private final AuthService authService;

    @PostMapping(ApiRoutes.LOGIN)
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping(ApiRoutes.REFRESH)
    public LoginResponse refresh(@RequestBody @Valid RefreshRequest refreshRequest) {
        return authService.refresh(refreshRequest);
    }

    @PostMapping(ApiRoutes.LOGOUT)
    @PreAuthorize("isAuthenticated()")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void logout(
        @RequestHeader String authorization,
        @RequestBody @Valid RefreshRequest refreshRequest
    ) {
        var token = authorization.substring(JwtBearerDefaults.TOKEN_TYPE.length());
        authService.logout(token, refreshRequest);
    }

}
