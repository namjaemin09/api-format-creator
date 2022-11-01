package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.util.JsonBeautify;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.io.FileNotFoundException;

class AoaParseServiceTest {
    @InjectMocks
    AoaParseService aoaParseService;

    @Test
    public void convert_xml_to_json () {
        String basePath = "C:\\Users\\NAMJAEMIN\\Desktop\\WORKSPACE\\AOA\\AOA_ADMIN_ETC\\xml\\service\\CMO\\";
        basePath = basePath.replace("\\", "/");
        String fileName = "CMO.COMMON.xml";



        System.out.println(JsonBeautify.getBeautifyJson(aoaParseService.getJSONTargetData(basePath+fileName)));

    }

    @Test
    public void file_not_found_exception () throws FileNotFoundException {

        aoaParseService.getJSONTargetData("");
    }
}