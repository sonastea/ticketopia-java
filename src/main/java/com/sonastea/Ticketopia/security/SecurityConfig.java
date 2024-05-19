package com.sonastea.Ticketopia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String pw1 = "{bcrypt}$2a$10$yjzWoBkxgCFcH73nePo.uOvcUY/3ZBRWGAKrKtvnW/NPPHjZhcRaW";
    private static final String pw2 = "{bcrypt}$2a$10$VvTLU7k0WJm6EFsozoZhVet/HjMgeyOlIVbhcb0sMco7AVlXHPgqu";

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        manager.createUser(User.withUsername("user").password(pw1).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(pw2).roles("USER", "ADMIN").build());

        return manager;
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/greeting").authenticated().anyRequest().permitAll()).formLogin(Customizer.withDefaults());

        return http.build();
    }

}