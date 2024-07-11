package com.kh.app.conf.interceptor;

import com.kh.app.interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns("/adminEmpMngr/**")
                .addPathPatterns("/adminDeptMngr/**")
                .excludePathPatterns("/adminHr/adminHrLogin", "/adminHr/adminHrLoginData", "/adminEmpMngr/searchData");
    }
}
