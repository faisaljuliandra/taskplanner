package com.faisaldev.taskplanner.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubTaskResponses {
    private String id;
    private String name;
    private String taskId;
    private String taskName;
}
