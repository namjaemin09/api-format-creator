package com.coocon.apiteam.testcreator.filter;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

@WebFilter(urlPatterns = {"/*"})
@Slf4j
@NoArgsConstructor
public class DebugFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init LoggingFilter");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        MDC.put("traceId", UUID.randomUUID().toString());

        log.info("###### HTTP REQUEST INPUT - {}) ######",req.getRequestURI());
        log.debug("HTTP REQUEST HEADER");
        req.getHeaderNames().asIterator().forEachRemaining(
                header ->
                        log.debug("key : value  [{} : {}]",header, req.getHeader(header))
        );
        log.debug("HTTP REQUEST KEY");
        req.getParameterNames().asIterator().forEachRemaining(
                header ->
                        log.debug("key : value [{} : {}]",header, req.getHeader(header))
        );

        chain.doFilter(request, response);
        log.info("###### HTTP RESPONSE OUTPUT status {} ######", res.getStatus());
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
