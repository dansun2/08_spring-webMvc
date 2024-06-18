package com.ohgiraffers.boardpractice.controller;

import ch.qos.logback.core.model.Model;
import com.ohgiraffers.boardpractice.model.dto.PostDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainContoller {

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv) {
        List<PostDTO> posts = new ArrayList<>();

        posts.add(new PostDTO("Sample1","https://picsum.photos/536/354", "https://www.naver.com"));
        posts.add(new PostDTO("Sample2","https://placehold.co/600x400/EEE/31343C", "https://www.naver.com"));
        posts.add(new PostDTO("Sample3","https://picsum.photos/536/354", "https://www.naver.com"));

        mv.addObject("posts", posts);

        mv.setViewName("index");
        return mv;
    }

}
