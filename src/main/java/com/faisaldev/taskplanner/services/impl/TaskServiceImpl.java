package com.faisaldev.taskplanner.services.impl;

import com.faisaldev.taskplanner.dtos.requests.TaskRequsts;
import com.faisaldev.taskplanner.dtos.responses.TaskResponses;
import com.faisaldev.taskplanner.exception.ErrorException;
import com.faisaldev.taskplanner.models.Tasks;
import com.faisaldev.taskplanner.repositories.TaskRepository;
import com.faisaldev.taskplanner.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addTask(TaskRequsts request) {
        Tasks taskName = taskRepository.findByName(request.getName());

        if (taskName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        Tasks tasks = new Tasks();
        tasks.setName(request.getName());
        taskRepository.save(tasks);
    }

    @Override
    public List<TaskResponses> getAllTasks() {
        List<Tasks> tasks = taskRepository.findAll();

        return tasks
                .stream()
                .map(result -> TaskResponses
                        .builder()
                        .id(result.getId())
                        .name(result.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponses searchByName(String name) {
        Tasks tasks = taskRepository.findByName(name);

        return TaskResponses.builder()
                .id(tasks.getId())
                .name(tasks.getName())
                .caseNumber(tasks.getCaseNumber())
                .build();
    }

    @Override
    public void updateTask(String id, TaskRequsts request) {
        Tasks taskName = taskRepository.findByName(request.getName());
        Tasks tasks = taskRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Task not found!", HttpStatus.NOT_FOUND));

        if (taskName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        tasks.setName(request.getName());
        taskRepository.save(tasks);
    }

    @Override
    public void deleteTask(String id) {
        Tasks tasks = taskRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Task not found!", HttpStatus.NOT_FOUND));
        taskRepository.delete(tasks);
    }
}
