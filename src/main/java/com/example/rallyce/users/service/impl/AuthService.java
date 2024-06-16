package com.example.rallyce.users.service.impl;

import com.example.rallyce.users.domain.auth.AuthResponse;
import com.example.rallyce.users.domain.auth.LoginRequest;
import com.example.rallyce.users.domain.auth.RegisterRequest;
import com.example.rallyce.users.domain.entities.Role;
import com.example.rallyce.users.domain.entities.User;
import com.example.rallyce.users.jwt.JwtService;
import com.example.rallyce.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .nombre(request.getNombre())
                .pais(request.getPais())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER.name())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
