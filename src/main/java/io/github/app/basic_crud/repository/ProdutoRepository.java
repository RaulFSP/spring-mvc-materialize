/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package io.github.app.basic_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.app.basic_crud.model.produto.Produto;



/**
 *
 * @author Administrator
 */
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
