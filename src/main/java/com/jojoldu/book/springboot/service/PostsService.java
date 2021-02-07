package com.jojoldu.book.springboot.service;


import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import com.jojoldu.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



// 스프링에서 Bean을 주입하는 방식
// 1. @Autowired 2. setter 3. 생성자
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 롬복의 @RequiredArgsConstructor가 대신 생성함
                         // (의존성 변경 관련해 계속 수정하는 번거로움 해결하기 위해)
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
