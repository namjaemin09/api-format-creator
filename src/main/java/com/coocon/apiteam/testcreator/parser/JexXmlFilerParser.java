package com.coocon.apiteam.testcreator.parser;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor
public class JexXmlFilerParser {

    @Autowired
    DocumentBuilder documentBuilder;

    public Document getDocument (File file) throws IOException, SAXException {
        return documentBuilder.parse(file);
    }



}
