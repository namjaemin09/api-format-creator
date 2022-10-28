package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.target.*;
import com.coocon.apiteam.testcreator.util.XPathUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPathExpressionException;

@Slf4j
@NoArgsConstructor
@Service
@Getter
public class AoaTargetService {
    XPathUtil xPathUtil;

    static final String INPUT_RULE_PATH ="//rule/in/item";
    static final String OUTPUT_RULE_PATH ="//rule/out/item";

    @Autowired
    AoaTargetService(XPathUtil xPathUtil){
        this.xPathUtil = xPathUtil;
    }

    public Lump getLumpFromXml(String type, String fileName) {

        Document document = xPathUtil.getDocument(fileName);
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
            default:
                return new Lump();
        }
    }

    public Lump getLump(String type){
        return new Lump();
    }

}
