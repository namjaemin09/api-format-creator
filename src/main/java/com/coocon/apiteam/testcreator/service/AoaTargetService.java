package com.coocon.apiteam.testcreator.service;

import com.coocon.apiteam.testcreator.parser.JexXmlFilerParser;
import com.coocon.apiteam.testcreator.target.*;
import com.coocon.apiteam.testcreator.util.XPathUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPathExpressionException;

@Slf4j
@Service
@Getter
@RequiredArgsConstructor
public class AoaTargetService {
    final XPathUtil xPathUtil;
    final JexXmlFilerParser jexXmlFilerParser;



    public Lump getLumpFromFilePath(String Path){
        return null;
    }
    public Lump getLump(String type){
        return new Lump();
    }
}
