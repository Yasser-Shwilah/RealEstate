package com.realestate.Real_Estate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/advertisements/**").permitAll()
            .requestMatchers("/api/advertisement-requests/**").permitAll()
            .requestMatchers("/api/cleaning-services/**").permitAll()
            .requestMatchers("/api/cleaning-service-customers/**").permitAll()
            .requestMatchers("/api/complaints/**").permitAll()
            .requestMatchers("/api/insuranceservices/**").permitAll()
            .requestMatchers("/api/loans/**").permitAll()
            .requestMatchers("/api/loan-requests/**").permitAll()
            .requestMatchers("/api/property-locations/**").permitAll()
            .requestMatchers("/api/realties/**").permitAll()
            .requestMatchers("/api/notifications/**").permitAll()
            .requestMatchers("/api/realties/**").permitAll()
            .requestMatchers("/api/realty-images/**").permitAll()
            .requestMatchers("/api/realty-insurances/**").permitAll()
            .requestMatchers("/api/realty-views/**").permitAll()
            .requestMatchers("/api/reviews/**").permitAll()
            .requestMatchers("/api/views/**").permitAll()
            .requestMatchers("/api/roles/**").permitAll()
            .requestMatchers("/api/transport-services/**").permitAll()
            .requestMatchers("/api/transport-service-customers/**").permitAll()
                // .requestMatchers("/api/advertisements/**").hasAnyRole("ADMIN", "MANAGER") // السماح فقط لـ ADMIN و MANAGER بالوصول إلى الإعلانات
            .requestMatchers("/api/users/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();

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

