package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.domain.member.member.service.MemberService;
import com.ll.sb20231114.global.rq.Rq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor // 생성자 주입
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;
    private final Rq rq;
    @GetMapping("/list")
    String showList(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);

        return "article/article/list";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping ("/write")
    String showWrite() {
        return "article/article/write";
    }

    @GetMapping("/detail/{id}")
        String showDetail(Model model, @PathVariable long id) {
        // PathVariable 을 사용하여 몇번 게시물을 보여줘야 할지 입력받음.
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);

        return "article/article/detail";
    }

    @Data
    public static class WriteForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("/write")
    @PreAuthorize("isAuthenticated()")
    String write(@Valid WriteForm writeForm, HttpServletRequest req) {
        Article article = articleService.write(rq.getMember(),writeForm.title, writeForm.body);

        return rq.redirect("/", "%d번 게시물 생성되었습니다.".formatted(article.getId()));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    String showModify(Model model, @PathVariable long id) {
        Article article = articleService.findById(id).get();

        if (!articleService.canModify(rq.getMember(), article)) throw new RuntimeException("수정권한이 없습니다.");

        model.addAttribute("article", article);

        return "article/article/modify";
    }
    @Data
    public static class ModifyForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/modify/{id}")
    String modify(@PathVariable long id, @Valid ModifyForm modifyForm) {
        Article article = articleService.findById(id).get();


        if (!articleService.canModify(rq.getMember(), article)) throw new RuntimeException("수정권한이 없습니다.");

        articleService.modify(article, modifyForm.title, modifyForm.body);
        return rq.redirect("/", "%d번 게시물 수정되었습니다.".formatted(id));
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable long id) {
        Article article = articleService.findById(id).get();

        if (!articleService.canDelete(rq.getMember(), article)) throw new RuntimeException("삭제권한이 없습니다.");

        articleService.delete(article);

        return rq.redirect("/", "%d번 게시물 삭제되었습니다.".formatted(id));
    }
}

