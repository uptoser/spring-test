package me.ibeyond.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import me.ibeyond.exception.DemoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("me.ibeyond")
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		return new StandardServletMultipartResolver();
	}
	
	@Override//静态资源？
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override//静态资源
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径。
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/js/");
	}

	@Override//添加拦截器
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DemoInterceptor());
	}

	@Override//添加页面跳转
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("index").setViewName("index");
		registry.addRedirectViewController("teset111", "aaa111");
	}
	
	
	
	
	
	
	
	
}
