1. POST /member/joi

2. String join(@Valid WriteForm joinForm) {

3. WriteForm 객체 생성

4. HttpServletRequest req
payload
username : aa
password : bbb

writeForm.username = "aa";
writeForm.password = "bbb";

5. 유효성 체크 => 통과

6. 해당 정보를 서비스에 넘김

7. 서비스가 객체 조립

8. 조립된 객체를 서비스가 저장하라고 리포지터리에게 넘김


9. 리포지터리가 해당 객체가 새것인지 체크
새 id 부여

10. 저장소에 저장

11. 리포지터리 리턴

12. 서비스 리턴

13. 여기 머물지 말고 당신 브라우저의 주소창에

/member/login?msg=~~~~

를 입력하세요.

14. 브라우저가 해당 명령을 수행
GET /member/login