package com.coocon.apiteam.testcreator.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@NoArgsConstructor
@ToString
@Setter
public class TargetFileConfiguration {
    /*
    @Value("${file_base_path.imo}")
    private String imoPath;
    @Value("${file_base_path.svc}")
    private String svcPath;
    @Value("${file_base_path.ido}")
    private String idoPath;
    @Value("${file_base_path.cmo}")
    private String cmoPath;
    @Value("${file_base_path.wsvc}")
    private String wsvcPath;
    */
    private String imoPath = "./target_sample/imo";
    private String svcPath = "./target_sample/svc";
    private String idoPath = "./target_sample/ido";
    private String cmoPath = "./target_sample/cmo";
    private String wsvcPath = "./target_sample/wsvc";

}
