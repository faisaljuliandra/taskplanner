package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.enums.RolePermission;
import com.faisaldev.taskplanner.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, String> {
    Optional<Roles> findByRole(RolePermission name);
}
