package com.ohgiraffers.testappflashattribute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView result2(Model model, String selection, @RequestParam("selection") String value, ModelAndView mv, RedirectAttributes rttr){
        if("poor".equals(selection)) {

            //리다이렉트 이후에 사용할 속성을 추가
            rttr.addFlashAttribute("result2", "거지입니다.");
            mv.setViewName("redirect:/");
            return mv;
        }
        mv.addObject("selection", selection); // 뭘 추가하는거지?
        mv.addObject("message", value); // 뭘 추가하는거지?
        mv.setViewName("result1");
        return mv;
    }

//    @GetMapping("goodSelect")
//    public ModelAndView GoodSelect(@RequestParam("selection") String value, ModelAndView mv){
//        mv.addObject("selection", value);
//        mv.addObject("selection", value);
//        mv.setViewName("redirect:/");
//        return mv;
//    }

}
