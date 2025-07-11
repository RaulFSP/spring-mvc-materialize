/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.github.app.basic_crud.service.LoginService;



/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {


    @Autowired
    private LoginService loginService;

    @GetMapping
    public ModelAndView login(ModelAndView mv) {
        return loginService.getLoginPage(mv);
    }
    
}
