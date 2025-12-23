package com.codequest.codequest_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuración de seguridad mínima para proveer
 * el Bean de BCryptPasswordEncoder en la aplicación.
 * 
 * No habilita seguridad completa de Spring Security,
 * solo permite usar el codificador de contraseñas.
 */
@Configuration
public class SecurityConfig {

    /**
     * Bean para codificar contraseñas usando BCrypt.
     * Se puede inyectar en cualquier servicio.
     *
     * @return BCryptPasswordEncoder
     */
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

