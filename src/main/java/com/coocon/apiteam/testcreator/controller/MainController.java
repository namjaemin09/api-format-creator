package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.parser.XmlDocumentBuilder;
import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.coocon.apiteam.testcreator.service.AoaTargetService;
import groovyjarjarpicocli.CommandLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
@NoArgsConstructor
@Slf4j
public class MainController {

    AoaParseService aoaParseService;
    AoaTargetService aoaTargetService;

    @Autowired
    MainController(AoaTargetService aoaTargetService, AoaParseService aoaParseService){
        this.aoaTargetService = aoaTargetService;
        this.aoaParseService = aoaParseService;

    }
    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model,
                             @RequestParam(required = false)String targetName,
                             @RequestParam(required = false) String basePath,
                             @RequestParam(required = false) String type){
        log.debug("model = {} , target name = {}",model.toString(),targetName);
        model.addAttribute("test","test입니다~!");

        if(basePath != null && type != null & targetName != null){
            model.addAttribute("data" , aoaTargetService.getLumpFromXml(type,basePath+targetName));
        }

        return "parser";
    }

    @GetMapping("/beans")
    public String printBean(Model model){
        log.debug("############# INTRODUCE BEANS #################");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(XmlDocumentBuilder.class);
        for(String beanName :  applicationContext.getBeanDefinitionNames()){
           log.debug(beanName);
        }
        log.debug("############# BEAN INTRODUCTION END #################");
        return "main";
    }

}
