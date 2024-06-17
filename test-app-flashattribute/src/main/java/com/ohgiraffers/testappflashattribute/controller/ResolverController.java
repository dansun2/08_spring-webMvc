package com.ohgiraffers.testappflashattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ResolverController {

    @GetMapping("inputform")
    public String inputform(Model model) {
        model.addAttribute("message", "Hello World");
    return "inputform";
    }

    @GetMapping("selection")
    public String selection(Model model) {
        model.addAttribute("message", "Hello World");
        return "selection";
    }

    @GetMapping("result1")
    public ModelAndView result1(ModelAndView mv, @RequestParam("textmessage") String value) {
        mv.addObject("result1", value);
        mv.setViewName("result1");
        return mv;
    }

    @GetMapping("result2")
    public String result2(Model model, @RequestParam("selection") String value, ModelAndView mv){
        model.addAttribute("message", "거지 리다이렉트");
        model.addAttribute("selection", value);
        return "/result1";
    }

    @GetMapping("goodSelect")
    public ModelAndView GoodSelect(@RequestParam("selection") String value, ModelAndView mv){
        mv.addObject("selection", value);
        mv.addObject("selection", value);
        mv.setViewName("redirect:/");
        return mv;
    }

}
