package es.etg.daw.dawes.java.rest.restfull.auth.infraestructure.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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

    /* 
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    
        http.authorizeHttpRequests((requests) -> requests
            .requestMatchers("/categorias/**").hasRole("ADMIN")
            .requestMatchers("/productos/**").hasAnyRole("USER", "ADMIN"));
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    */

    
    //para probar la parte de pinta y colorea
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> cors.configure(http)) // Habilita CORS dentro de Spring Security
        .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para pruebas (opcional)
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
    
        return http.build();
    }

    /** Configuración para evitar el error de CORS que dará el navegador */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Permitimos todos los orígenes
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        
        // Permitimos los métodos necesarios
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Permitimos todas las cabeceras
        configuration.setAllowedHeaders(Arrays.asList("*"));
        
        // Permitimos que el navegador reciba la respuesta
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}