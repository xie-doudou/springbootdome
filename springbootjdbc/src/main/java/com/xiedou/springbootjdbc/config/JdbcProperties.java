package com.xiedou.springbootjdbc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JDBC配置属性类
 */
//@ConfigurationProperties(prefix = "jdbc") //是spring boot的注解不能读取其他配置文件，只能读取spring boot的配置文件application.properties文件
public class JdbcProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
