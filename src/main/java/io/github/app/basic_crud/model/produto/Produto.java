/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.model.produto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name="produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double preco;
    @Lob
    private String descricao;
    private String urlImagem;
    @CreationTimestamp
    private LocalDateTime created;

    public Produto(ProdutoDTOCreate dto){
        this.nome=dto.nome();
        this.preco=dto.preco();
        this.descricao=dto.descricao();
        this.urlImagem=dto.urlImagem();
    }
}
