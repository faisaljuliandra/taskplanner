package com.faisaldev.taskplanner.services;

import com.faisaldev.taskplanner.dtos.requests.SubTaskRequests;
import com.faisaldev.taskplanner.dtos.responses.SubTaskResponses;

import java.util.List;

public interface SubTaskService {
    void addSubTask(SubTaskRequests request);
    List<SubTaskResponses> getAllSubTasks();
    SubTaskResponses searchByName(String name);
    void updateSubTask(String id, SubTaskRequests request);
    void deleteSubTask(String id);
}
