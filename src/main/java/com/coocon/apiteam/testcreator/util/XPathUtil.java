package com.coocon.apiteam.testcreator.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Component
@NoArgsConstructor
@Getter
public class XPathUtil {
    DocumentBuilder documentBuilder;
    XPath xPath;

    @Autowired
    XPathUtil(DocumentBuilder documentBuilder,XPath xPath){
        this.documentBuilder = documentBuilder;
        this.xPath = xPath;
    }
    public NodeList getNodeListFromPath(Document document, String path) throws XPathExpressionException {
        return (NodeList) getXPathExpression(path).evaluate(document, XPathConstants.NODESET);
    }

    public XPathExpression getXPathExpression(String path) {
        try {
            return xPath.compile(path);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Document getDocument(String fileName) {
        try {
            File xmlFile = new File(fileName);
            if(xmlFile== null ){
                throw new FileNotFoundException("File [" + fileName + "] is not exists");
            }
            return documentBuilder.parse(xmlFile); // xml 문서를 Document 객체로 파싱
        } catch (SAXException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
