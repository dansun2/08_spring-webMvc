package com.ohgiraffers.testappflashattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = {"/"})
    public String main(){
        return "index";
    }

//    @GetMapping("/mission1")
//    public ModelAndView mission()
}
