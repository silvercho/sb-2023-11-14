package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    private Article[] articles = new Article[3];
    private int articlesLastIndex = -1;

    @GetMapping("/article/write")
    String showWrite(){
        return "article/write";
    }
    @GetMapping("article/doWrite")
    @ResponseBody
    RsData doWrite (
            String title,
            String body
    ){
        Article article = new Article(articlesLastIndex + 2, title, body);

        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );
        String resultCode = rs.getResultCode();
        String msg = rs.getMsg();
        Article _article = (Article) rs.getData();

        return rs;
    }
    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles[articlesLastIndex];
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    Article[] getArticles() {
        return articles;
    }
}
    @AllArgsConstructor
    @Getter
    class RsData<T>{
        private String resultCode;
        private String msg;
        private T data;
    }
    @AllArgsConstructor
    @Getter
    class Article {
        private long id;
        private String title;
        private String body;
    }
