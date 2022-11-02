package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.configuration.TargetFileConfiguration;
import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.coocon.apiteam.testcreator.service.AoaTargetService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final AoaParseService aoaParseService;
    private final AoaTargetService aoaTargetService;
    private final TargetFileConfiguration targetFileConfiguration;

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model){

        File idoDirectory = new File(targetFileConfiguration.getIdoPath());
        File imoDirectory = new File(targetFileConfiguration.getImoPath());
        File svcDirectory = new File(targetFileConfiguration.getSvcPath());
        File wsvcDirectory = new File(targetFileConfiguration.getWsvcPath());
        File bcsDirectory = new File(targetFileConfiguration.getBcsPath());
        File cmoDirectory = new File(targetFileConfiguration.getBcsPath());

        model.addAttribute("IDO_LIST",idoDirectory.list());
        model.addAttribute("IMO_LIST",imoDirectory.list());
        model.addAttribute("SVC_LIST",svcDirectory.list());
        model.addAttribute("BCS_LIST",wsvcDirectory.list());
        model.addAttribute("WSVC_LIST",bcsDirectory.list());
        model.addAttribute("CMO_LIST",cmoDirectory.list());
        return "parserMain";
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
