package com.faisaldev.taskplanner.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyResponses {
    private String id;
    private String name;
}
