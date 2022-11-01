package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.util.XPathUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
@Getter
@RequiredArgsConstructor
public class AoaParseService {

   private final XPathUtil xPathUtil;
   public JSONObject getJSONTargetData(String filePath) {
       try {
           return xPathUtil.xmlToJson(new File(filePath));
       } catch (IOException e) {
           log.error("FileNotFoundException error!! filePath = [{}]", filePath);
           return null;
           //throw new RuntimeException(e);
       }
   }

}
