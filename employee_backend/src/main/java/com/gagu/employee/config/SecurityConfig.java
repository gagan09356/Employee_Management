package com.gagu.employee.config;

import com.gagu.employee.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


    @Autowired
    EmployeeServiceImpl employeeService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                //.securityMatcher("/api/auth/logoutUser")
                .csrf(AbstractHttpConfigurer:: disable)
                .authorizeHttpRequests(
                     registry -> {
                        registry.requestMatchers("/api/auth/register").permitAll();
                        registry.requestMatchers("/api/auth/loginUser").hasRole("USER");
                        registry.requestMatchers("/api/auth/logoutUser").permitAll();
                        registry.anyRequest().authenticated();
                    })
                    /*httpBasic(Customizer.withDefaults()).
                    sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))*/
                .formLogin(AbstractAuthenticationFilterConfigurer ::permitAll)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(employeeService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
