package com.pluralsight.springbootconferencedemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

  @Value("${spring.datasource.url}")
  private String url;

  @Bean
  public DataSource dataSource() {
    DataSourceBuilder<?> builder = DataSourceBuilder.create();
    builder.url(url);
    System.out.println("My custom datasource bean has been initialized and set");
    return builder.build();
  }
}
