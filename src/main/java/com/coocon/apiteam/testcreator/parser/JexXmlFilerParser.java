package com.coocon.apiteam.testcreator.parser;

import com.coocon.apiteam.testcreator.configuration.TargetFileConfiguration;
import com.coocon.apiteam.testcreator.target.*;
import com.coocon.apiteam.testcreator.util.XPathUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class JexXmlFilerParser {

    final XPathUtil xPathUtil;
    final TargetFileConfiguration targetFileConfiguration;
    static final String INPUT_RULE_PATH ="//rule/in/item";
    static final String OUTPUT_RULE_PATH ="//rule/out/item";
    static final String SUB_RULE_PATH ="//rule/subRule";


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
        log.debug("type = {} fileName = {}",type,fileName);
        String filePath = targetFileConfiguration.getFilePathByType(type);
        Document document = getDocument(filePath+fileName);
        NodeList inputNodeList;
        NodeList outputNodeList;
        NodeList subRuleNodeList;
        HashMap<String, Node> subRuleMap;
        try {
            inputNodeList = xPathUtil.getNodeListFromPath(document,INPUT_RULE_PATH);
            outputNodeList = xPathUtil.getNodeListFromPath(document,OUTPUT_RULE_PATH);
            subRuleNodeList =xPathUtil.getNodeListFromPath(document,SUB_RULE_PATH);

            Lump lump = createLump(LumpTypeEnum.valueOf(type));

            if(subRuleNodeList != null){
                for(int i=0; i<inputNodeList.getLength(); i++){

                }
            }

            if(inputNodeList != null){
                lump.setInputRules(getRulesFromNodeList(inputNodeList));
            }
            else {
                log.info("inputNodeList is null!");
            }

            if(outputNodeList != null){
                lump.setOutputRules(getRulesFromNodeList(outputNodeList));
            }
            else {
                log.info("outputNodeList is null!");
            }

            return lump;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Item getItemFromNode(NamedNodeMap namedNodeMap){
        String padding = namedNodeMap.getNamedItem("padding").getNodeValue();
        String length = namedNodeMap.getNamedItem("length").getNodeValue();
        String name = namedNodeMap.getNamedItem("name").getNodeValue();
        String id = namedNodeMap.getNamedItem("id").getNodeValue();
        String fullChar = namedNodeMap.getNamedItem("fullChar").getNodeValue();
        namedNodeMap.
        namedNodeMap.getNamedItem("typeDat").getNodeValue();
        String align = namedNodeMap.getNamedItem("align").getNodeValue();

        // item = Item.builder().
        //        padding(padding).length(length).name(name).
        //        id(id).fullChar(fullChar).typeDat(typeDat).align(align).build();
        Item item = Item.builder().
                padding(padding).length(length).name(name).
                id(id).fullChar(fullChar).align(align).build();

        return item;
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

    public LinkedHashMap<String, Item> getRulesFromNodeList(NodeList nodelist){
        LinkedHashMap<String, Item> linkedHashMap = new LinkedHashMap<String,Item>();

        for(int i=0; i<nodelist.getLength(); i++){
            NamedNodeMap namedNodeMap = nodelist.item(i).getAttributes();

            linkedHashMap.put(namedNodeMap.getNamedItem("id").getNodeValue(), getItemFromNode(namedNodeMap));
        }
        return linkedHashMap;
    }
}
