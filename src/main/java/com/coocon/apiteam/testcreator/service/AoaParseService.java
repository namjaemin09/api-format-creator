package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.converter.XmlToJsonConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
@NoArgsConstructor
@Service
@Getter
public class AoaParseService {

    private XmlToJsonConverter xmlToJsonConverter = new XmlToJsonConverter();

    public JSONObject getJSONTargetData(String filePath){
        try {
            return xmlToJsonConverter.xmlToJson(new File(filePath));
        } catch (IOException e) {
            log.error("FileNotFoundException error!! filePath = [{}]", filePath);
            return null;
            //throw new RuntimeException(e);
        }
    }
}
