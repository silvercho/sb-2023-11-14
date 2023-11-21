package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.global.rq.Rq.Rq;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor // 생성자 주입
public class ArticleController {

    private final ArticleService articleService;
    private final Rq rq;
    @GetMapping ("article/write")
    String showWrite(){
        return "article/write";
    }

    @GetMapping("/article/detail/{id}")
    @ResponseBody
    String showDetail(@PathVariable long id) {
        // PathVariable 을 사용하여 몇번 게시물을 보여줘야 할지 입력받음.
        Optional<Article> opArticle = articleService.findById(id);
        Article article = opArticle.get();

        return "article/detail";
    }
    @Data
    public static class WriteForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("article/write")

    String write(@Valid WriteForm writeForm) {
        Article article = articleService.write(writeForm.title, writeForm.body);

        String msg = "id%d, article created".formatted(article.getId());

        return "redirect:/article/list?msg=" + msg;
    }

    @GetMapping("/article/list")
    String showList(Model model) {
        List<Article> articles = articleService.findAll();

        model.addAttribute("articles", articles);

        return "article/list";
    }

    @GetMapping ("article/getLastArticle")
    @ResponseBody
    Article getLastArticle(){
        return articleService.findLastArticle();
    }
    @GetMapping ("article/getArticle")
    @ResponseBody
    List<Article> getArticle(){
        return articleService.findAll();
    }

    @GetMapping("/article/articleServicePointer")
    @ResponseBody
    String articleServicePointer(){
        return articleService.toString();
    }
    @GetMapping("/article/httpServletRequestPointer")
    @ResponseBody
    String httpServletRequestPointer(HttpServletRequest req) {
        return req.toString();
    }

    @GetMapping("/article/httpServletResponsePointer")
    @ResponseBody
    String httpServletResponsePointer(HttpServletResponse resp) {
        return resp.toString();
    }
    @GetMapping("/article/rqPointer")
    @ResponseBody
    String rqPointer() {
        return rq.toString();
    }
    @GetMapping("/article/rqTest")
    String showRqTest(Model model) {
        String rqToString = rq.toString();

        model.addAttribute("rqToString", rqToString);

        return "article/rqTest";
    }
}

