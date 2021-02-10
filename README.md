# SpringBoot 로 만드는 프로젝트

# local에서 h2 console 접근
- `http://localhost:8080/h2-console` 로 접근한다.
- JDBC URL은 변경 필요
 > As-Is: jdbc:h2:~/test
 > To-Be: jdbc:h2:mem:testdb
 > connect 시작

- 화면에서 쿼리 수행
```
select * from posts;

insert into posts (author, content, title) values ('author', 'content', 'title');
```
- API 호출   
`http://localhost:8080/api/v1/posts/1`
  

## Mustache 연결
- plugin 설치
- main/resources/templates/index.mustache 생성
- main/java/com/jojoldu/book/springboot/web/IndexController 생성하여 연결함
