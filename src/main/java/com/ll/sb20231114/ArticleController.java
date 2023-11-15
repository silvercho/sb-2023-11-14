package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    // 이 배열은 게시물들을 저장하는 곳이에요.
    private Article[] articles = new Article[3];
    // 최대 3개의 게시물을 저장 할 수 있는 공간을 만듭니다. 글이 3개이상 저장되지 않게 제한을 둡니다.
    // 이 변수는 articles 배열에서 마지막에 사용된 인덱스를 추적해요.
    private int articlesLastIndex = -1;
    // 새글이 추가 될 때마다 이 값은 증가하며 배열에서 어디까지 글이 저장되었는지 알려줘요.,
    // -1로 초기화 한 이유는 아직 글이 추가 되지 않았음을 나타내요.
    @GetMapping ("article/write")
    String showWrite(){
        return "article/write";
    }
    @GetMapping ("article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ){
        Article article = new Article((articlesLastIndex +2),title,body);
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
        return articles[articlesLastIndex];// 배열에서 마지막에 작성된 글을 반환해요.
    }
    @GetMapping ("article/getArticle")
    @ResponseBody
    Article[] getArticle(){
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
