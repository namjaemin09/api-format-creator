package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.service.AoaParseService;
import groovyjarjarpicocli.CommandLine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.server.PathParam;

@Controller
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class MainController {

    @Autowired
    AoaParseService aoaParseService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("test","test입니다~!");
        return "main";
    }

    @GetMapping("/parser")
    public String parserPage(Model model, @PathVariable String targetName, @PathVariable String basePath){
        log.debug("model = {} , target name = {}",model.toString(),targetName);
        model.addAttribute("test","test입니다~!");
        model.addAttribute("jsonObject" , aoaParseService.getJSONTargetData(basePath+targetName) );
        return "parser";
    }


}
