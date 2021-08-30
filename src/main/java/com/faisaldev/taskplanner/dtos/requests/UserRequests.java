package com.faisaldev.taskplanner.dtos.requests;

import lombok.Data;

@Data
public class UserRequests {
    private String username;
    private String email;
    private String password;
    private String fullName;
}
