package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.coocon.apiteam.testcreator.service.AoaTargetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final AoaParseService aoaParseService;
    private final AoaTargetService aoaTargetService;


    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model){;

        model.addAttribute("test","test 입니다~!");
        model.addAttribute("IMO_LIST","test 입니다~!");
        model.addAttribute("SVC_LIST","test 입니다~!");
        model.addAttribute("BCS_LIST","test 입니다~!");
        model.addAttribute("WSVC_LIST","test 입니다~!");

        return "parser";
    }

    @GetMapping("/beans")
    public String printBean(Model model){
        log.debug("############# INTRODUCE BEANS #################");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AoaTargetService.class);
        for(String beanName :  applicationContext.getBeanDefinitionNames()){
           log.debug(beanName);
        }
        log.debug("############# BEAN INTRODUCTION END #################");
        return "main";
    }

}
