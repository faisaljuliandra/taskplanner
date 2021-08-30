package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, String> {
    @Query(value = "SELECT * FROM tasks WHERE tasks.name ILIKE %?1%", nativeQuery = true)
    Tasks findByName(String name);
    @Query(value = "SELECT * FROM tasks WHERE tasks.case_number ILIKE %?1%", nativeQuery = true)
    Tasks findByCaseNumber(String caseNumber);
}
