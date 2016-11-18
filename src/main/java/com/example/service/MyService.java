package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.config.DatabaseContextHolder;
import com.example.model.DatabaseType;
import com.example.model.NGTenantDatabase;
import com.example.repo.NGTenantDatabaseRepository;

@Service
public class MyService {

    @Autowired
    private NGTenantDatabaseRepository repo;

    public void testeFindAllFirstDatasource() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.DB2);
        repo.findAll().stream().map(NGTenantDatabase::getCdTenant).forEach(System.out::println);
    }

    public void testeFindAllSecondDatasource() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.DB1);
        repo.findAll().stream().map(NGTenantDatabase::getCdTenant).forEach(System.out::println);
    }

}
