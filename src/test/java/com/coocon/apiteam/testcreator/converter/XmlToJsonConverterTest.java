package com.coocon.apiteam.testcreator.converter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XmlToJsonConverterTest {

    @Test
    public void convert_xml_to_json () {
        String basePath = "";
        String fileName = "";

        XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();

        try {
            xmlToJsonConverter.xmlToJson(new File(basePath+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void file_not_found_exception () throws FileNotFoundException {
        String basePath = "";
        String fileName = "";

        XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();
        assertThrows(FileNotFoundException.class, ()->{
            xmlToJsonConverter.xmlToJson(new File(basePath+fileName));
        });
    }
}