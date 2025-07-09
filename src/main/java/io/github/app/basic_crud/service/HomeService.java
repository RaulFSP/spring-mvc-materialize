/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.app.basic_crud.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Service
public class HomeService {

    public ModelAndView getHome(ModelAndView mv){
        mv.setViewName("home");
        return mv;
    }
}
