package com.waylau.spring.boot.blog.initializrstart.controller;

import com.waylau.spring.boot.blog.initializrstart.repository.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*blog控制器*/
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private EsBlogRepository blogRepository;
   /* @GetMapping
    public List<EsBlog> list(@RequestParam(value = "title") String title,@RequestParam(value = "summary") String summary,
                             @RequestParam(value = "content") String content,@RequestParam(value = "pagaIndex",defaultValue = "0")
                                     int pageIndex,@RequestParam(value = "pageSize" ,defaultValue = "10") int pageSize ){
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<EsBlog> page = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);
        return page.getContent();
    }*/
   @GetMapping
    public String listBlogs(@RequestParam(value = "order",required = false,defaultValue = "new") String order,@RequestParam(value = "keyword",required = false,defaultValue = "") String keyword){
       System.out.println("order:"+order+" ; keyword:"+keyword);
       return "redirect:/index?order="+order+"&keyword="+keyword;
   }
}
