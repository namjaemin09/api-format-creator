package com.coocon.apiteam.testcreator.converter;

import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
public class XmlToJsonConverter {

    public JSONObject xmlToJson(File file) throws IOException {
        return  XML.toJSONObject(new FileReader(file, StandardCharsets.UTF_8));
    }

}
