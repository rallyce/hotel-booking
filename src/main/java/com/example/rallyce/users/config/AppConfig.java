package com.example.rallyce.users.config;

import com.example.rallyce.users.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final UserRepository userRepository;
}
