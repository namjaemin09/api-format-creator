package com.coocon.apiteam.testcreator.parser;

import com.coocon.apiteam.testcreator.target.*;
import com.coocon.apiteam.testcreator.util.XPathUtil;
import groovy.util.logging.Slf4j;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JexXmlFilerParser {

    final XPathUtil xPathUtil;
    static final String INPUT_RULE_PATH ="//rule/in/item";
    static final String OUTPUT_RULE_PATH ="//rule/out/item";
    static final String SUB_RULE_PATH ="//rule/out/item";


    public Document getDocument(String fileName) {
        try {
            File xmlFile = new File(fileName);
            if(xmlFile== null ){
                throw new FileNotFoundException("File [" + fileName + "] is not exists");
            }
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile); // xml 문서를 Document 객체로 파싱
        } catch (SAXException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public Lump getLumpFromXml(String type, String fileName) {
        Document document = getDocument(fileName);
        NodeList inputNodeList;
        NodeList outputNodeList;
        try {
            inputNodeList = xPathUtil.getNodeListFromPath(document,INPUT_RULE_PATH);
            outputNodeList = xPathUtil.getNodeListFromPath(document,OUTPUT_RULE_PATH);

            Lump lump = createLump(LumpTypeEnum.valueOf(type));

            if(inputNodeList != null){

            }

            if(outputNodeList != null){

            }

            return lump;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private Lump createLump(LumpTypeEnum lumpTypeEnum) {
        switch(lumpTypeEnum){
            case SVC:
                return new Svc();
            case IMO:
                return new Imo();
            case IDO:
                return new Ido();
            case CMO:
                return new Common();
            case WSVC:
                return new Wsvc();
            default:
                return null;
        }
    }
}
