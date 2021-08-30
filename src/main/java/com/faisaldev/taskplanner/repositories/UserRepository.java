package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    @Query(value = "SELECT * FROM users WHERE users.full_name ILIKE %?1%", nativeQuery = true)
    Optional<Users> findByFullName(String fullName);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
    @Query(value = "SELECT * FROM users WHERE users.username = ?1", nativeQuery = true)
    Users findDistinctByUsername(String username);
    @Query(value = "SELECT * FROM users WHERE users.email = ?1", nativeQuery = true)
    Users findDistinctByEmail(String email);
}
