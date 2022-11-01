package com.coocon.apiteam.testcreator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class XPathUtil {

    public NodeList getNodeListFromPath(Document document, String path) throws XPathExpressionException {
        return (NodeList) getXPathExpression(path).evaluate(document, XPathConstants.NODESET);
    }

    public XPathExpression getXPathExpression(String path) {
        try {
            return XPathFactory.newInstance().newXPath().compile(path);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public JSONObject xmlToJson(File file) throws IOException {
        return  XML.toJSONObject(new FileReader(file, StandardCharsets.UTF_8));
    }
}
