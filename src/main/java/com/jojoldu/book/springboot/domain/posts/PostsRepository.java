package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// ibatis, MyNBatis의 Dao와 같은 DB Layer 접근자임
// JpaRepository<Entity 클래스, PK타입>을 상속하면 기본 CRUD 메소드가 자동 생성
// 단, Entity클래스와 Repository는 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts>  findAllDesc();
}
