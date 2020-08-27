package com.example.internationalization.config.locale;

import com.example.internationalization.config.interceptor.CustomizeLocaleChangeInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * i18n配置
 */
@Configuration
public class LocaleConfig {

    /**
     * 默认本地化解析器
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        //指定默认语言
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return localeResolver;
    }

    /**
     * 默认本地化拦截器
     */
    @Bean("customizeLocaleChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor() {
        CustomizeLocaleChangeInterceptor localeChangeInterceptor = new CustomizeLocaleChangeInterceptor();
        //自定义国际化参数
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    // result code : 响应码信息国际化配置

    @Bean("resultCodeMessageResource")
    public MessageSource resultCodeMessageResource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        //指定国际化的Resource Bundle地址
        resourceBundleMessageSource.setBasename("i18n/ResultCodeMessages");
        //指定国际化的默认编码
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }

    @Bean("resultCodeLocaleMessage")
    public LocaleMessage resultCodeLocaleMessage() {
        return new LocaleMessage(resultCodeMessageResource());
    }

}
