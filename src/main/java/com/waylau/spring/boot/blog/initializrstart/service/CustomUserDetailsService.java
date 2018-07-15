package com.waylau.spring.boot.blog.initializrstart.service;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import com.waylau.spring.boot.blog.initializrstart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpServletRequest servletRequest;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            System.out.println(user.getUsername());
            if (user == null){
                throw new UsernameNotFoundException("用户名不存在！");
            }
            HttpSession session=servletRequest.getSession();
            session.setAttribute("user",user);
            session.setAttribute("sessusername",username);
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            System.out.println(user.getUsername()+authorities.toString());
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
