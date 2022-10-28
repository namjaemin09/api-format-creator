package com.coocon.apiteam.testcreator.parser;

import groovy.util.logging.Slf4j;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

@NoArgsConstructor
@Slf4j
@Component
public class JexXmlFilerParser {

    DocumentBuilder documentBuilder;

    @Autowired
    public JexXmlFilerParser(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }


    public Document getDocument (File file)  {
        try {
            return documentBuilder.parse(file);
        } catch (SAXException e) {

            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
