package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class) // SpringBoot와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class,
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    }
) // WEB에 집중할 수 있는 어노 테이션(@Controller/ @ControllerAdvice등을 사용 가능, 단, @Service, @Component, @Repository 사용 불가)
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈을 주입받음
    private MockMvc mvc; // 웹 API 테스트시에 사용함, 스프링 MVC의 시작점[GET, POST등의 테스트 가능]

    @WithMockUser(roles = "USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소 요청, 체이닝 지원
                .andExpect(status().isOk()) // mvc.perform의 결과를 검증함, 200 OK인지 확인
                .andExpect(content().string(hello)); // mvc.perform의 결과 검증, 응답본문 확인
    }

    @WithMockUser(roles = "USER")
    @Test
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) // param은 String값만 허용됨(이외 값은 String 전환 후 사용)
                        .param("amount", String.valueOf(amount)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name", is(name))) // JSON 응답값을 필드별로 검증할 수 있는 메소드($를 기준으로 필드명의 명시합니다.)
                        .andExpect(jsonPath("$.amount", is(amount))
        );
    }
}
