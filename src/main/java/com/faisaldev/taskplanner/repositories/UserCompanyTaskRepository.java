package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.models.UserCompanyTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCompanyTaskRepository extends JpaRepository<UserCompanyTasks, String> {
    @Query(value = "SELECT * FROM user_company_tasks INNER JOIN users ON user_company_tasks.user_id = users.id WHERE user_company_tasks.user_id = ?1", nativeQuery = true)
    List<UserCompanyTasks> findByUsers(String userId);
}
