- 이렇게 하면 해당 Article 객체의 수명은 articleController가 삭제되기 전까지 유지된다.

- 물론 새 Article 객체가 등록되면 바로 기존 Article 객체는 삭제된다.

- 참고로 articleController 객체의 수명은 앱의 수명과 같다.(즉 프로그램이 꺼질 때 까지 계속 유지된다.)
 
>어떠한 클래스를 설계할 때
범용적으로 만들려면 Object 남발할 수 밖에 없다.
자바 5에서 제너릭 문법 도입(미완성 클래스)

>객체 생성할 때 클래스 완성
List<String> list = new ArrayList<>();