package com.redpanda.restaurante.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilitamos CSRF para que los POST desde el frontend no fallen
            .csrf(csrf -> csrf.disable())
            
            // 2. Activamos la configuración de CORS que definimos abajo
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // 3. Gestión de permisos de rutas
            .authorizeHttpRequests(auth -> auth
                // IMPORTANTE: Aquí añadimos todas las rutas que el frontend necesita leer libremente
                .requestMatchers(
                    "/**"

                ).permitAll()
                
                // Cualquier otra ruta (como admin o perfiles) pedirá login
                .anyRequest().authenticated()
            )
            
            // 4. DESACTIVAR EL CUADRO DE LOGIN GRIS DEL NAVEGADOR
            .httpBasic(basic -> basic.disable())
            .formLogin(form -> form.disable());
        
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // El origen debe ser exactamente el de tu Vite/Vue
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        
        // Permitimos todos los métodos (GET para platos, POST para login, etc.)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Cabeceras necesarias
        configuration.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization", "X-Requested-With", "Accept"));
        
        // ¡VITAL! Esto permite que el navegador guarde la sesión (cookies)
        configuration.setAllowCredentials(true);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}