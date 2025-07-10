/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.app.basic_crud.model.produto.ProdutoDTOCreate;
import io.github.app.basic_crud.service.ProdutoService;
import jakarta.validation.Valid;



/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value="/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;    

    @GetMapping
    public ModelAndView produto(ModelAndView mv, ProdutoDTOCreate dto) {
        return produtoService.getProduto(mv);
    }
    
    @PostMapping("/novo")
    public String novoProduto(@Valid ProdutoDTOCreate dto,BindingResult result) {
        return produtoService.postProdutoNovo(dto, result);
    }
    
}
