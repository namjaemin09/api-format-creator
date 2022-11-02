package com.coocon.apiteam.testcreator.configuration;

import com.coocon.apiteam.testcreator.service.AoaParseService;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


class TargetFileConfigurationTest {
    @InjectMocks
    AoaParseService aoaParseService;
    @InjectMocks
    private Environment environment;

    private static String ttest;

    @Value("${gamza.test}")
    public void setTtest(String ttest) {
        this.ttest = ttest;
    }

    @Test
    public void print_base_path(){
        TargetFileConfiguration targetFileConfiguration = new TargetFileConfiguration();

        System.out.println(targetFileConfiguration);

        assertNotNull(targetFileConfiguration.getIdoPath());
        assertNotNull(targetFileConfiguration.getSvcPath());
        assertNotNull(targetFileConfiguration.getImoPath());
        assertNotNull(targetFileConfiguration.getWsvcPath());
        assertNotNull(targetFileConfiguration.getCmoPath());

    }

    @Test
    public void print_config_data(){
        System.out.println(ttest);
    }

    @Test
    public void get_yml_data(){
        System.out.println(environment);
    }

    @Test
    public void get_file(){

        assertNotNull(aoaParseService.getJSONTargetData("./target_sample/CMO.COMMON.xml"));

    }

    @Test
    public void get_file_list(){
        System.out.println();
    }
}