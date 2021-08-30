package com.faisaldev.taskplanner.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequests {
    private String email;
    private String password;
}
