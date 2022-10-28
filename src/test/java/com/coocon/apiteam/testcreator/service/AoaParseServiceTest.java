package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.converter.XmlToJsonConverter;
import com.coocon.apiteam.testcreator.util.JsonBeautify;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AoaParseServiceTest {
    @Test
    public void convert_xml_to_json () {
        String basePath = "C:\\Users\\NAMJAEMIN\\Desktop\\WORKSPACE\\AOA\\AOA_ADMIN_ETC\\xml\\service\\CMO\\";
        basePath = basePath.replace("\\", "/");
        String fileName = "CMO.COMMON.xml";

        AoaParseService aoaParseService = new AoaParseService();


        System.out.println(JsonBeautify.getBeaurifyJson(aoaParseService.getJSONTargetData(basePath+fileName)));

    }

    @Test
    public void file_not_found_exception () throws FileNotFoundException {
        AoaParseService aoaParseService = new AoaParseService();

        aoaParseService.getJSONTargetData("");
    }
}