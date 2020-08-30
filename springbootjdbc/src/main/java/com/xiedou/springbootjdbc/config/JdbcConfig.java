package com.xiedou.springbootjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 数据源的jdbc配置类
 */
//@Configuration
//@PropertySource("classpath:/jdbc.properties")//加载指定的properties配置文件
//@EnableConfigurationProperties(JdbcProperties.class)//指定加载那个配置信息类
public class JdbcConfig {
    @Autowired
    private JdbcProperties jdbcProperties;
    /**
     * 实例化Druid
     */
    @Bean
    public DataSource getDataSource(){
        DruidDataSource source=new DruidDataSource();
        source.setUsername(this.jdbcProperties.getUsername());
        source.setPassword(this.jdbcProperties.getPassword());
        source.setDriverClassName(this.jdbcProperties.getDriverClassName());
        source.setUrl(this.jdbcProperties.getUrl());

        return source;
    }
}
