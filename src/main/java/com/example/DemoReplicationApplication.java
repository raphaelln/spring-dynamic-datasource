package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.example.service.MyService;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
public class DemoReplicationApplication implements CommandLineRunner {

    @Autowired
    private MyService service;

    public static void main(String[] args) {
        SpringApplication.run(DemoReplicationApplication.class, args);
    }

    @Override
    public void run(String... args) {
        service.testeFindAllFirstDatasource();
        service.testeFindAllSecondDatasource();
    }

}
