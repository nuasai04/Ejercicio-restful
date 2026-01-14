package es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.db.jpa.repository.UserEntityRepository;
import es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final UserEntityRepository repository;


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> UserMapper.toAuth(UserMapper.toDomain(repository.findByEmail(username)));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}