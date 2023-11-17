- 이렇게 하면 해당 Article 객체의 수명은 articleController가 삭제되기 전까지 유지된다.

- 물론 새 Article 객체가 등록되면 바로 기존 Article 객체는 삭제된다.

- 참고로 articleController 객체의 수명은 앱의 수명과 같다.(즉 프로그램이 꺼질 때 까지 계속 유지된다.)
 
>어떠한 클래스를 설계할 때
범용적으로 만들려면 Object 남발할 수 밖에 없다.
자바 5에서 제너릭 문법 도입(미완성 클래스)

>객체 생성할 때 클래스 완성
List<String> list = new ArrayList<>();

> ArticleService 라는 요리사를 두어 점원이 해야하는일(고객응대) 빼고는 전부 토스
> ArticleRepository 라는 요리재료창고 관리직원을 두어 요리사가 순수 요리에만 집중 할 수 있도록
> (34) 창고에서 데이터를 가져오고 / 수정하고/ 삭제하고/ 추가하는 단순한 일들을 전부 토스

> (37) 성능상과 기능상에 차이가 없지만 / 동료개발자를 위해, 가독성을 위해
> @Component 대신 @Service 와 @Repository 라는 어노테이션을 적재적소에 활용
> 