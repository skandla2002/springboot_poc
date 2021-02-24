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


## 구글 서비스 등록
- `https://console.cloud.google.com` 이동

## Naver 로그인 등록
- `https://developers.naver.com/apps/#/register?api=nvlogin` 이동

## 테스트 실행
- Gradle Tab > Tasks > verification > test 실행

## AWS 서버 환경 구축
- 24시간 서버 형태: 집 PC 24시간, 호스팅서비스(cafe24 등), 클라우드 서비스(AWS, GCP, AZURE 등)
- Cloud 서비스 분류
1. IaaS(아이아스, 이에스): 인프라 대여, AWS의 EC2나 S3
2. PaaS(파스): AWS의 Beanstalk, Heroku 등
3. SaaS(사스): 구글 드라이브, 드랍박스, 와탭 등