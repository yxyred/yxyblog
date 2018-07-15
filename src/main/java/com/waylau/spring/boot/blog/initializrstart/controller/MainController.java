package com.waylau.spring.boot.blog.initializrstart.controller;

import com.waylau.spring.boot.blog.initializrstart.domain.Authority;
import com.waylau.spring.boot.blog.initializrstart.domain.User;
import com.waylau.spring.boot.blog.initializrstart.repository.UserRepository;
import com.waylau.spring.boot.blog.initializrstart.service.AuthorityService;
import com.waylau.spring.boot.blog.initializrstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*主页控制器*/
@RestController
@RequestMapping("/")
public class MainController {
    private static final Long ROLE_USER_AUTHORITY_ID = 2L;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserService userService;
    public String root(){
        return "redirect:/index";
    }
    @GetMapping("/index")
    public ModelAndView index(){

        return new ModelAndView("index");
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
    @GetMapping("/register")
    public ModelAndView register(Model model){
        model.addAttribute("user",new User(null,null,null,null));
        return new ModelAndView("register","userModel",model);
    }
    @PostMapping("/register")
    public ModelAndView create(User user) {
       // user = userRepository.save(user);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities( authorities);
        user.setEncodePassword(user.getPassword());
        userService.saveUser(user);
        return new ModelAndView("redirect:/index");
    }
}
