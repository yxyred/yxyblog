package com.waylau.spring.boot.blog.initializrstart.controller;

import org.springframework.web.bind.annotation.*;

/*blog控制器*/
@RestController
@RequestMapping("/u")
public class UserspaceController {

   @GetMapping("/{username}")
   public String userSpace(@PathVariable("usename") String username){
        System.out.println("username"+username);
        return "/userspaces/u";
   }
   @GetMapping("/{username}/blogs")
    public String listBlogs(@RequestParam(value = "username") String username,
                            @RequestParam(value = "order",required = false,defaultValue = "new") String order,
                            @RequestParam(value = "category",required = false) String category,
                            @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
       if(category != null){
           System.out.println("category:"+category+" ;");
           System.out.println("selflink:"+" redirect;/u/"+username+"/blogs?category="+category);
           return "/userspace/u";
       }else if(keyword != null && keyword.length() >0){
           System.out.println("keyword:"+keyword+" ;");
           System.out.println("selflink:"+" redirect;/u/"+username+"/blogs?keyword="+keyword);
           return "/userspace/u";
       }
       System.out.println("order:"+order+" ;");
       System.out.println("selflink:"+" redirect;/u/"+username+"/blogs?order="+order);
       return "/userspace/u";
   }
   @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
       System.out.print("blogId:"+id);
       return "/userspace/blog";
   }
   @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
       return "/userspace/blogedit";
   }
}
