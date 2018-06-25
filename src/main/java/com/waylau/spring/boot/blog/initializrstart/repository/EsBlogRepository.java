package com.waylau.spring.boot.blog.initializrstart.repository;

import com.waylau.spring.boot.blog.initializrstart.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
/*
* 分页查询去重*/
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
