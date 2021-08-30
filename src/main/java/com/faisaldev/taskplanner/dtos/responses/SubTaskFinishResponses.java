package com.faisaldev.taskplanner.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class SubTaskFinishResponses {
    private String id;
    private String name;
    private Boolean isFinished;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date finishDate;
}
