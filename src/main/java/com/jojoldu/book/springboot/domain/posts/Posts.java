package com.jojoldu.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가(public Posts(){}와 같은 효과
@Entity // 주요 어노테이션을 클래스에 가깝게 둔다.(DB와 연결된 class로 Entity 클래스라고 불리움)
        // 테이블과 링크될 클래스 임, 기본값으로는 카멜 케이스 이름을 언더 스코어 네이밍으로 테이블 이름 매칭함
        // (SalesManager.java > sales_manager table)
public class Posts {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙, 부트 2.0 버전에서는 GenerationType.IDENTITY옵션 추가해야 auto_increment가 됨
    private Long id;

    @Column(length = 500, nullable = false) // 테이블 칼럼을 나타내고 해당 클래스의 필드는 모두 컬럼 값이 된다.
                                            // 기본값 이외 추가 변경 필요 옵션 있을때 사용
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언지 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 트랜잭션 안에서 데이터 베이스에서 데이터를 가져오면 영속성 유지(트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영)
    // 더티체킹(https://jojoldu.tistory.com/415)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
