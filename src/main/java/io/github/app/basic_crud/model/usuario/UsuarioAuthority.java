/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.model.usuario;

import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name="usuario_authorities")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioAuthority implements GrantedAuthority{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String authority;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    

    public UsuarioAuthority(String authority, Usuario usuario) {
        this.authority = authority;
        this.usuario = usuario;
    }



    @Override
    public String getAuthority() {
        return this.authority;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioAuthority other = (UsuarioAuthority) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
