package com.rscharitas.dataPP;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * Created with IntelliJ IDEA.
 * User: altaire
 * Date: 8/2/13
 * Time: 9:20 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ImportResource({"classpath*:/spring-security.xml"})
public class SecurityConfig {
    @Bean
    public DelegatingFilterProxy springSecurityFilterChain() {
        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
        return filterProxy;

    }

}
