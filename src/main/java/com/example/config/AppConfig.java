package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.example")
public class AppConfig implements WebMvcConfigurer {

@Bean
public JdbcTemplate getJdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    DriverManagerDataSource dataSource= new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUsername("postgres");
    dataSource.setPassword("2103");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/employee");

    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
}

@Bean
public ViewResolver getViewResolver(){
    InternalResourceViewResolver viewResolver =new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
}











}
