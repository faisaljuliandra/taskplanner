package com.faisaldev.taskplanner.dtos.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SubTaskFinishRequests {
    private String subTaskId;
    private Boolean isFinished;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date finishDate;
}
