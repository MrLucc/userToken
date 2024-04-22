package br.pratiqs.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfigurations {
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return null;
    }
}
