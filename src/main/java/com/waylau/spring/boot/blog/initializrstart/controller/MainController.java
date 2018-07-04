package com.waylau.spring.boot.blog.initializrstart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {
    public String root(){
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public ModelAndView login(Model model){
        return new ModelAndView("login", "userModel", model);
    }
    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登陆失败，用户名或者密码错误");
        return "login";
    }
}
