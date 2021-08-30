package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.models.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Companies, String> {
    @Query(value = "SELECT * FROM companies WHERE companies.name ILIKE %?1%", nativeQuery = true)
    Companies findByName(String name);
}
