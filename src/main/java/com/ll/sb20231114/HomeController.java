package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping ("/clac")
    @ResponseBody
    String showCalc(int a , int b){
        return "계산 결과 : %d".formatted(a+b);
    }
    @GetMapping ("/clac2")
    @ResponseBody
    String showCalc2(Integer a , Integer b){
        return "a : " + a + " , b : " + b;
    }
    @GetMapping ("/clac3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue =  "0") int a,
            @RequestParam(defaultValue =  "0") int b
    ){
        return "계산 결과 : %d".formatted(a+b);
    }
    // http://localhost:8020/clac3?a=10&b=20

    @GetMapping ("/clac4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue =  "0") double a,
            @RequestParam(defaultValue =  "0") double b
    ){
        return "계산 결과 : %d".formatted(a+b);
    }

    @GetMapping ("/clac5")
    @ResponseBody
    String showCalc5(
            @RequestParam(defaultValue =  "0") String a,
            @RequestParam(defaultValue =  "0") String b
    ){
        return "계산 결과 : %d".formatted(a+b);
    }
}
