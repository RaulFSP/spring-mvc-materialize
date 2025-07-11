/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.app.basic_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Administrator
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    

    @Bean
    public SecurityFilterChain sfc(HttpSecurity hs) throws Exception {
        return hs
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**","/error", "/error/**"))
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/h2/**", "/css/**", "/js/**","/error", "/error/**").permitAll()
                .anyRequest().authenticated())
                .formLogin((fl) -> fl.loginPage("/login").defaultSuccessUrl("/").permitAll())
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/").permitAll())
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    

}
