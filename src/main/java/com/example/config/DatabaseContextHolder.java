package com.example.config;

import org.springframework.util.Assert;

import com.example.model.DatabaseType;

public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<DatabaseType>();

    public static void clearDatabaseType() {
        contextHolder.remove();
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType databaseType) {
        Assert.notNull(databaseType, "databaseType cannot be null");
        contextHolder.set(databaseType);
    }
}