package com.example.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.model.DatabaseType;

@Configuration
public class DatabaseConfig {

    @Bean
    public DynamicRoutingDataSourceResolver dataSource() {
        final DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

        final Map<Object, Object> dataSources = new HashMap<>();
        dataSources.put(DatabaseType.DB2, firstDataSource());
        dataSources.put(DatabaseType.DB1, secondDataSource());
        resolver.setTargetDataSources(dataSources);
        return resolver;
    }

    @Bean
    @ConfigurationProperties(prefix = "first.datasource")
    public DataSource firstDataSource() {
        final DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    @Bean
    @ConfigurationProperties(prefix = "second.datasource")
    public DataSource secondDataSource() {
        final DataSource ds = DataSourceBuilder.create().build();
        return ds;
    }

    Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return properties;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan("com.example.model");
        factoryBean.setJpaProperties(additionalProperties());
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManager() {

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
