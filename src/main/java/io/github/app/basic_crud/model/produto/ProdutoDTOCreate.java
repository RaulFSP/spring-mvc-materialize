/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package io.github.app.basic_crud.model.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Administrator
 */
public record ProdutoDTOCreate(
        @NotBlank
        String nome,
        @NotNull
        Double preco,
        @NotBlank
        String descricao,
        @NotBlank
        String urlImagem) {

}
