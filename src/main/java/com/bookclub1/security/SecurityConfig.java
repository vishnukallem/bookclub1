package com.bookclub1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/about", "/contact").permitAll()  // Allow these pages for everyone
                .anyRequest().authenticated()                           // Require authentication for all others
            )
            .formLogin(form -> form
                .loginPage("/login")    // Custom login page
                .permitAll()            // Allow everyone to see the login page
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")  // Redirect to home after logout
                .permitAll()            // Allow all users to log out
            );

        return http.build();
    }
}
