/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import io.github.app.basic_crud.model.produto.Produto;
import io.github.app.basic_crud.model.produto.ProdutoDTOCreate;
import io.github.app.basic_crud.repository.ProdutoRepository;
/**
 *
 * @author Administrator
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ModelAndView getProduto(ModelAndView mv){
        mv.setViewName("produto-pagina");
        return mv;
    }

    public String postProdutoNovo(ProdutoDTOCreate dto, BindingResult result){
        if(result.hasErrors()){
            return "/produto";
        }
        System.out.println("antes");
        produtoRepository.save(new Produto(dto));
        System.out.println("depois");
        return "redirect:/produtos";
    }
}
