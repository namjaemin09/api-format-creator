package com.coocon.apiteam.testcreator.controller;


import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.coocon.apiteam.testcreator.service.AoaTargetService;
import com.coocon.apiteam.testcreator.target.Lump;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parser")
@RequiredArgsConstructor
@Slf4j
public class ParsedDataController {

    private final AoaParseService aoaParseService;
    private final AoaTargetService aoaTargetService;

    @GetMapping("/data")
    public Lump getParsedData(){
        log.debug("mapping get parsed data");

        return null;
    }
}
