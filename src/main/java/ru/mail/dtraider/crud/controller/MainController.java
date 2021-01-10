package ru.mail.dtraider.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/login")
    public ModelAndView getLogin(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @GetMapping("/")
    public ModelAndView getBack(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
