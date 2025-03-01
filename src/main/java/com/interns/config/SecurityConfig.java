package com.interns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public/**").permitAll()

                        .requestMatchers("/api/mentors").hasRole("ADMIN")
                        .requestMatchers("/api/mentors/**").hasRole("ADMIN")
                        .requestMatchers("/api/projects").hasRole("ADMIN")
                        .requestMatchers("/api/projects/**").hasRole("ADMIN")
                        .requestMatchers("/api/teams").hasRole("ADMIN")
                        .requestMatchers("/api/teams/**").hasRole("ADMIN")

                        .requestMatchers("/api/interns").authenticated()
                        .requestMatchers("/api/interns/**").authenticated()
                        .requestMatchers("/api/tasks").authenticated()
                        .requestMatchers("/api/tasks/**").authenticated()
                        .requestMatchers("/api/**").authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .httpBasic(httpBasic -> {});

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
