package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.global.rsData.RsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    // 이 배열은 게시물들을 저장하는 곳이에요.
    private List<Article> articles = new ArrayList<>();
    @GetMapping ("article/write")
    String showWrite(){
        return "article/write";
    }
    @PostMapping("article/write")
    @ResponseBody
    RsData write(
            String title,
            String body
    ){
        Article article = new Article((articles.size() + 1),title,body);
        articles.add(article);

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );

        return rs;
    }
    @GetMapping ("article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articles.getLast();
    }
    @GetMapping ("article/getArticle")
    @ResponseBody
    List<Article> getArticle(){
        return articles;
    }

}

