package com.faisaldev.taskplanner.dtos.requests;

import lombok.Data;

@Data
public class UserCompanyTaskRequests {
    private String userId;
    private String companyId;
    private String taskId;
    private String subTaskId;
}
