/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package io.github.app.basic_crud.model.produto;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public record ProdutoDTORead(
    String nome,
    Double preco,
    String descricao,
    String urlImagem,
    LocalDate created
) {

    public ProdutoDTORead(Produto produto){
        this(produto.getNome(), produto.getPreco(),produto.getDescricao(),produto.getUrlImagem(),produto.getCreated().toLocalDate());
    }
}
