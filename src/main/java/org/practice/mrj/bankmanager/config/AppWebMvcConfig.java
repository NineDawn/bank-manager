package org.practice.mrj.bankmanager.config;

import org.practice.mrj.bankmanager.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: AppWebMvcConfig
 * Description:
 *
 * @Author: Nine Dawn
 * @Date: 2020/12/4 22:33
 * @Version: 1.0
 */
@Component
public class AppWebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private AuthInterceptor authInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/bank/account/login")
                .excludePathPatterns("/bank/account/getNewCard")
                .excludePathPatterns("/bank/account/addAccount");
    }
}
