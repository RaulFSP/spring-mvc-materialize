/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.app.basic_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2/**").permitAll()

                .requestMatchers("/produtos/**").permitAll()
                .anyRequest().permitAll())
                .csrf(csrf->csrf.disable())
                // .csrf(csrf->csrf.ignoringRequestMatchers("/h2/**"))
                .headers(headers-> headers.frameOptions(frame->frame.disable()))
                
        .build();
    }

    
}
