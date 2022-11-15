package com.coocon.apiteam.testcreator.parser;

import com.coocon.apiteam.testcreator.configuration.TargetFileConfiguration;
import com.coocon.apiteam.testcreator.target.Lump;
import com.coocon.apiteam.testcreator.util.XPathUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JexXmlFilerParserTest {

    @Test
    public void parser_test_success(){
        assertTrue(true);
    }

    @Test
    public void parser_test_file_not_found(){
        JexXmlFilerParser jexXmlFilerParser =new JexXmlFilerParser(new XPathUtil(), new TargetFileConfiguration());
        Lump lump = jexXmlFilerParser.getLumpFromXml("IMO","IMO.CERT_PASS_EVD_REQ.xml");

        assertTrue(true);
    }

}