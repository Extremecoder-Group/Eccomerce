package com.extremecoder.productservice.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

/**
 * Message Configuration
 *
 * @author Badrul
 */
@Configuration
public class MessageConfiguration {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message/messages");
        messageSource.setCacheSeconds(-1); //reload messages every 10 seconds
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public PropertiesFactoryBean propertiesfilemapping() {
        PropertiesFactoryBean factoryBean = new PropertiesFactoryBean();
        factoryBean.setFileEncoding("UTF-8");
        factoryBean.setLocation(new ClassPathResource("message/messages_bn_BD.properties"));
        return factoryBean;
    }

}
