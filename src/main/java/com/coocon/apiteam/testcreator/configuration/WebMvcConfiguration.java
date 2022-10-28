package com.coocon.apiteam.testcreator.configuration;

import com.coocon.apiteam.testcreator.filter.DebugFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class WebMvcConfiguration {

    @Bean
    public FilterRegistrationBean filterBean() {

        //FilterRegistrationBean registrationBean = new FilterRegistrationBean(new LoggingFilter());
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new DebugFilter());
        registrationBean.setOrder(0);
        registrationBean.addUrlPatterns("/*"); //전체 URL 포함
//        registrationBean.addUrlPatterns("/test/*"); //특정 URL 포함
//        registrationBean.setUrlPatterns(Arrays.asList(INCLUDE_PATHS)); //여러 특정 URL 포함

        //registrationBean.setUrlPatterns(Arrays.asList("/test/*", "/test2/*"));

        return registrationBean;
    }


}
