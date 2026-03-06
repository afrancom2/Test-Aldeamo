package com.aldeamo.test.application.services.services;

import com.aldeamo.test.domain.model.request.LoginRequest;
import com.aldeamo.test.domain.model.response.LoginResponse;
import com.aldeamo.test.infraestructure.config.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getDocumentNumber(), request.getPassword())
        );
        String token = jwtService.generateToken((UserDetails) auth.getPrincipal());
        return new LoginResponse(token);
    }
}
