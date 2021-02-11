package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){ // 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장(결과를 index.mustache에 전달)
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
//    public String index(){
//        return "index";
//    }


    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
