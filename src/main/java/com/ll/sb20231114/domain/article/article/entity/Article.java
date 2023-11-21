package com.ll.sb20231114.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString // 객체 내용을 출력하도록
public class Article {
    private Long id;
    private String title;
    private String body;

    public Article(String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
