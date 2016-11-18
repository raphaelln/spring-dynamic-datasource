package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.NGTenantDatabase;


@Repository
public interface NGTenantDatabaseRepository extends JpaRepository<NGTenantDatabase, Integer> {

    NGTenantDatabase findByCdTenant(final String cdTenant);

}
