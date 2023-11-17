package com.ll.sb20231114.domain.article.article.service;

import com.ll.sb20231114.domain.article.article.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component // 저는 단 한번만 생성되고, 그 이후에는 재사용되는 객체입니다.

public class ArticleService {
    private final List<Article> articles = new ArrayList<>();

    public Article write(String title, String body) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        return article;
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}

