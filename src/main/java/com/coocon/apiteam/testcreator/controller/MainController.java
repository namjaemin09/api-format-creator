package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.coocon.apiteam.testcreator.service.AoaTargetService;
import groovyjarjarpicocli.CommandLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@Controller
@NoArgsConstructor
@Slf4j
public class MainController {

    AoaParseService aoaParseService;
    AoaTargetService aoaTargetService;

    MainController(AoaTargetService aoaTargetService, AoaParseService aoaParseService){
        this.aoaTargetService = aoaTargetService;
        this.aoaParseService = aoaParseService;
    }
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model,
                             @PathVariable(required = false)String targetName,
                             @PathVariable(required = false) String basePath,
                             @PathVariable(required = false) String type){
        log.debug("model = {} , target name = {}",model.toString(),targetName);
        model.addAttribute("test","test입니다~!");
        model.addAttribute("data" , aoaTargetService.getLumpFromXml(type,basePath+targetName));
        return "parser";
    }


}
