package com.vanlang;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class I18NConfig implements WebMvcConfigurer {
	@Bean("messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setDefaultEncoding("utf-8");
		ms.setBasenames("classpath:i18n/global");
		return ms;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor locale = new LocaleChangeInterceptor();
		locale.setParamName("lang");
		registry.addInterceptor(locale).addPathPatterns("/**").excludePathPatterns("/img/**");
	}

	@Bean("localeResolver")
	public LocaleResolver getLocaleResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieMaxAge(10 * 24 * 60 * 60); // 10 ngày
		resolver.setCookiePath("/");
		return resolver;
	}
}
