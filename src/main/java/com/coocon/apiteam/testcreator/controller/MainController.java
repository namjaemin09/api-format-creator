package com.coocon.apiteam.testcreator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "parser";
    }
}
