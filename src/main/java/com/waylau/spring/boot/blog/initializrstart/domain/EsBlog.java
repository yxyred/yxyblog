package com.waylau.spring.boot.blog.initializrstart.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;


@Data
@Document(indexName = "blog" , type = "blog")
public class EsBlog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected EsBlog(){}
    public EsBlog(String title, String summary, String content){
        this.title = title;
        this.content = content;
        this.summary = summary;
    }
    public String toString(){
        return String.format("EsBlog[id = '%d',title = '%s',summary=  '%s',content =  '%s']",id,title,summary,content);
    }
}
