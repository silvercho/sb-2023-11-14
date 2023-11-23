package com.ll.sb20231114.domain.article.article.entity;

import com.ll.sb20231114.domain.member.member.entity.Member;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString // 객체 내용을 출력하도록
@EqualsAndHashCode
public class Article {
    @EqualsAndHashCode.Include
    private Long id;
    private Member author;
    private String title;
    private String body;

    public Article(Member author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
