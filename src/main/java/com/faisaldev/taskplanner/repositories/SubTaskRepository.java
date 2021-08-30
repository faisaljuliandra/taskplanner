package com.faisaldev.taskplanner.repositories;

import com.faisaldev.taskplanner.models.SubTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTasks, String> {
    @Query(value = "SELECT * FROM sub_tasks WHERE sub_tasks.name ILIKE %?1%", nativeQuery = true)
    SubTasks findByName(String name);
}
