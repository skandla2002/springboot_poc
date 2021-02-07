package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // RequestParam은 외부의 API로 넘긴 파라미터를 가져옴
                                                                        // (name으로 넘김 param을 메소드 파라미터에 저장함)
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
