package com.example.controllers;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@EnableWebMvc
public class ViewConfiguration implements WebMvcConfigurer
{
    @Resource
    protected ApplicationContext applicationContext;
    
    @Resource
    protected SpringTemplateEngine springTemplateEngine;
    
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver()
	{
		final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		
		viewResolver.setViewNames(new String[]
		{ "thyme/*" });
		viewResolver.setExcludedViewNames(new String[]
		{ "jsp/*" });
		viewResolver.setTemplateEngine(springTemplateEngine);
		viewResolver.setCharacterEncoding("UTF-8");
		
		return viewResolver;
	}

	@Bean
	public InternalResourceViewResolver jspViewResolver()
	{
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewNames("jsp/*");
		
		return viewResolver;
	}

	@Bean
	public SpringResourceTemplateResolver thymeleafTemplateResolver()
	{
		final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		templateResolver.setOrder(0);
		
		return templateResolver;
	}

	@Bean
	public SpringResourceTemplateResolver jspTemplateResolver()
	{
		final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".jsp");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		templateResolver.setOrder(1);
		templateResolver.setCharacterEncoding("UTF-8");
		
		return templateResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
}
