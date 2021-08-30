package com.faisaldev.taskplanner.services;

import com.faisaldev.taskplanner.dtos.requests.TaskRequsts;
import com.faisaldev.taskplanner.dtos.responses.TaskResponses;

import java.util.List;

public interface TaskService {
    void addTask(TaskRequsts request);
    List<TaskResponses> getAllTasks();
    TaskResponses searchByName(String name);
    void updateTask(String id, TaskRequsts request);
    void deleteTask(String id);
}
