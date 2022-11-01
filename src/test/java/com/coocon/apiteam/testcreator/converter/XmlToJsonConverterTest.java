package com.coocon.apiteam.testcreator.converter;

import com.coocon.apiteam.testcreator.util.XPathUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlToJsonConverterTest {

    @InjectMocks
    XPathUtil xPathUtil;
    @Test
    public void convert_xml_to_json () {
        String basePath = "";
        String fileName = "";


        try {
            xPathUtil.xmlToJson(new File(basePath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void file_not_found_exception () throws FileNotFoundException {
        String basePath = "";
        String fileName = "";

        assertThrows(FileNotFoundException.class, ()->{
            xPathUtil.xmlToJson(new File(basePath+fileName));
        });
    }
}