package com.candy.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.candy.repository"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    /**
     * 国际化信息源类 ReloadableResourceBundleMessageSource
     * 可以设置配置文件的路径：file: classpath:
     * 并且可以在修改配置文件后不用重新启动程序，会自动扫描并重新加载
     *
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("file:///D:/DevelopmentKit/idea-workspace/java-workspace/spring_web_java_config/conf/message");
        messageSource.setCacheSeconds(10);
        return messageSource;
    }

    /**
     * 国际化信息源类 ResourceBundleMessageSource
     *
     * 会在根路径下查找 message.properties 文件
     *
     * @return
     */
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("message");
        return messageSource;
    }

}
