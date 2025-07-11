/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.app.basic_crud.repository.UsuarioRepository;

/**
 *
 * @author Administrator
 */
@Service
public class UsuarioDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var opt = usuarioRepository.findByUsername(username);
        if(opt.isPresent()){
            var user = opt.get();
            return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(user.getAuthorities()).build();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }

}
