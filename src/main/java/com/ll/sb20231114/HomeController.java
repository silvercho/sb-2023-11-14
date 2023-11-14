package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping ("/")
   // @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송 하라는 의미
    String showMain(){
        System.out.println("안녕하세요!!!"); // 콘솔에 출력됨
        return "안녕하세요.";
    }
    @GetMapping ("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }
}
