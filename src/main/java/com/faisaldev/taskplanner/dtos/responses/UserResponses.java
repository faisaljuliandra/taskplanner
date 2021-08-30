package com.faisaldev.taskplanner.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponses {
    private String id;
    private String username;
    private String email;
    private String fullName;
}
