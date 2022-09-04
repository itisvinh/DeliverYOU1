package com.deliveryou.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.util.HashMap;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.deliveryou.controller"
//        "com.deliveryou.service",
//        "com.deliveryou.repository"
})
public class Dispatcher implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // default view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(new HashMap() {{
            put("cloud_name", "de26tcplz");
            put("api_key", "263981385366449");
            put("api_secret", "5un8GhQMBEyOGgzKDW1g1D_FHBo");
            put("secure", true);
        }});
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**", "/css/**", "/img/**")
                .addResourceLocations("/resources/js/", "/resources/css/", "/resources/images/");
    }

    @PreDestroy
    public void deregisterJdbcDriver() {
        try {
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
        } catch (Exception ex) {
            System.out.println("[EXCEPTION] Deregister driver: " + ex.getMessage());
        }
    }

}
