1단계

http://localhost:8020/member/join

GET /member/join

2단계

3member/member/join.html -> layout 호출

4단계

global/layout.html 전반부 부분

5단계

member/member/join.html

6단계

global/layout.html 후반부 부분

**Post 방식으로 서버에 요청** 을 보내면 벌어지는 일들
1단계
POST /member/join
payload = (username=aaa,password=bbb)

2단계
요청매핑에 의해서 String join(@Valid WriteForm joinForm); 메서드에 매핑

3단계
WriteForm 객체 생성

4단계
HttpServletRequest req 에서 payload(username : aaa, password : bbb)를 꺼내서

3단계에서 만든객체에 삽입

writeForm.username = "aa";

writeForm.password = "bbb";

5단계
유효성 체크
방금 작업에서 @NotBlank 룰에 의거해서 만약에 비어있는 값이 입력되었다면 오류 발생

6단계
이후 내용은 영상을 참고해주세요.

