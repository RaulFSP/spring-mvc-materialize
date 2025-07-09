/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.app.basic_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import io.github.app.basic_crud.model.produto.ProdutoDTORead;
import io.github.app.basic_crud.repository.ProdutoRepository;

/**
 *
 * @author Administrator
 */
@Service
public class HomeService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ModelAndView getHome(ModelAndView mv) {
        List<ProdutoDTORead> dtos = produtoRepository.findAll().parallelStream().map(ProdutoDTORead::new).toList();
        mv.addObject("dtos", dtos);
        mv.setViewName("home");
        return mv;
    }
}
