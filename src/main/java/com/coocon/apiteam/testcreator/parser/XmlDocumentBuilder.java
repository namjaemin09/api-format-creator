package com.coocon.apiteam.testcreator.parser;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


@Configuration
@NoArgsConstructor
public class XmlDocumentBuilder {

    private Document doc;

    @Bean
    public DocumentBuilder documentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder();
    }
}
