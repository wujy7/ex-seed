package com.ex.seed.config;

import com.ex.seed.constant.SsoConstant;
import com.ex.seed.filter.SsoLoginFilter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziliang 2018-11-15
 */
@Configuration
public class SsoConfig implements DisposableBean {

    @Value("${sso.server}")
    private String ssoServer;

    @Value("${sso.excluded.paths}")
    private String ssoExcludedPaths;

    @Bean
    public FilterRegistrationBean redisSsoFilterRegistration() {
        // component-redis-sso, filter init
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("SsoLoginFilter");
        registration.setOrder(2);
        registration.addUrlPatterns("/*");
        registration.setFilter(new SsoLoginFilter());
        registration.addInitParameter(SsoConstant.SSO_SERVER, ssoServer);
        registration.addInitParameter(SsoConstant.SSO_EXCLUDED_PATHS, ssoExcludedPaths);

        return registration;
    }

    @Override
    public void destroy() throws Exception {
    }

}
