package com.faisaldev.taskplanner.services;

import com.faisaldev.taskplanner.dtos.requests.TaskRequsts;
import com.faisaldev.taskplanner.dtos.responses.TaskResponses;
import com.faisaldev.taskplanner.models.UserCompanyTasks;

import java.util.List;

public interface UserCompanyTaskService {
    void addUserCompanyTask(TaskRequsts request);
    List<TaskResponses> getAll();
    UserCompanyTasks searchByUser(String userId);
    TaskResponses searchByName(String name);
    void updateTask(String id, TaskRequsts request);
    void deleteTask(String id);
}
