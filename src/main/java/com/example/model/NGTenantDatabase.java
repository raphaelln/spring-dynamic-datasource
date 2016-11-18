package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "NG_TENANT_DATABASE")
public class NGTenantDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tenant_database")
    private Integer id;

    @Column(name = "cd_tenant", nullable = false)
    private String cdTenant;

    @Column(name = "nm_database", nullable = false)
    private String nmDatabase;

    public String getCdTenant() {
        return cdTenant;
    }

    public Integer getId() {
        return id;
    }

    public String getNmDatabase() {
        return nmDatabase;
    }

    public void setCdTenant(String cdTenant) {
        this.cdTenant = cdTenant;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNmDatabase(String nmDatabase) {
        this.nmDatabase = nmDatabase;
    }

}
