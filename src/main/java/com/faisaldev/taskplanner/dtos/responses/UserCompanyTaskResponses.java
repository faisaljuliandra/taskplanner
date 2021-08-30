package com.faisaldev.taskplanner.dtos.responses;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserCompanyTaskResponses {
    private String userId;
    private String username;
    private String companyId;
    private String companyName;
    private String taskId;
    private String taskName;
    private List<SubTaskFinishResponses> subTask;
}
