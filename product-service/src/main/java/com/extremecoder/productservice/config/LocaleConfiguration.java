package com.extremecoder.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Locale Configuration
 *
 * @author Badrul
 */
@Configuration
public class LocaleConfiguration implements WebMvcConfigurer {

    /**
     * @return localeResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
//        Locale locale = Locale.forLanguageTag("bn-BD");
//        sessionLocaleResolver.setDefaultLocale(locale);
        return sessionLocaleResolver;
    }
}
