package com.faisaldev.taskplanner.services.impl;

import com.faisaldev.taskplanner.dtos.requests.SubTaskRequests;
import com.faisaldev.taskplanner.dtos.responses.SubTaskResponses;
import com.faisaldev.taskplanner.dtos.responses.TaskResponses;
import com.faisaldev.taskplanner.exception.ErrorException;
import com.faisaldev.taskplanner.models.SubTasks;
import com.faisaldev.taskplanner.models.Tasks;
import com.faisaldev.taskplanner.repositories.SubTaskRepository;
import com.faisaldev.taskplanner.services.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    @Autowired
    private SubTaskRepository subTaskRepository;

    @Override
    public void addSubTask(SubTaskRequests request) {
        SubTasks subTaskName = subTaskRepository.findByName(request.getName());

        if (subTaskName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        SubTasks subTasks = new SubTasks();
        subTasks.setName(request.getName());
        subTaskRepository.save(subTasks);
    }

    @Override
    public List<SubTaskResponses> getAllSubTasks() {
        List<SubTasks> subTasks = subTaskRepository.findAll();

        return subTasks
                .stream()
                .map(result -> SubTaskResponses
                        .builder()
                        .id(result.getId())
                        .name(result.getName())
                        .taskId(result.getTask().getId())
                        .taskName(result.getTask().getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public SubTaskResponses searchByName(String name) {
        SubTasks subTasks = subTaskRepository.findByName(name);

        return SubTaskResponses.builder()
                .id(subTasks.getId())
                .name(subTasks.getName())
                .taskId(subTasks.getTask().getId())
                .taskName(subTasks.getTask().getName())
                .build();
    }

    @Override
    public void updateSubTask(String id, SubTaskRequests request) {
        SubTasks subTaskName = subTaskRepository.findByName(request.getName());
        SubTasks subTasks = subTaskRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Sub Task not found!", HttpStatus.NOT_FOUND));

        if (subTaskName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        subTasks.setName(request.getName());
        subTaskRepository.save(subTasks);
    }

    @Override
    public void deleteSubTask(String id) {
        SubTasks subTasks = subTaskRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Sub Task not found!", HttpStatus.NOT_FOUND));
        subTaskRepository.delete(subTasks);
    }
}
