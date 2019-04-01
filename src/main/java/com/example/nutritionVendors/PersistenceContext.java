package com.example.nutritionVendors;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceContext {
    @Bean
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName("org.postgresql.Driver");
        dataSourceConfig.setJdbcUrl("jdbc:postgresql://ec2-174-129-224-157.compute-1.amazonaws.com:5432/ddntq4gre733tp?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
        dataSourceConfig.setUsername("wfrmrpwggydzrz");
        dataSourceConfig.setPassword("c3a2d2a88f3f8e4d01d831b128e2c3651782ace53f98918238562988ecd982d2");

//
//        dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/freshfood?useUnicode=true&characterEncoding=UTF-8");
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("");

        return new HikariDataSource(dataSourceConfig);
    }
}