package com.faisaldev.taskplanner.services;

import com.faisaldev.taskplanner.dtos.requests.LoginRequests;
import com.faisaldev.taskplanner.dtos.requests.PasswordRequests;
import com.faisaldev.taskplanner.dtos.requests.UserRequests;
import com.faisaldev.taskplanner.dtos.responses.LoginResponses;
import com.faisaldev.taskplanner.dtos.responses.UserResponses;

public interface UserService {
    UserResponses registerUser(UserRequests request);
    LoginResponses loginUser(LoginRequests request);
    UserResponses getUserById(String id);
    UserResponses getUserByName(String fullName);
    UserResponses getUserByUsername(String username);
    void updateUser(String id, UserRequests request);
    void updatePassword(String id, PasswordRequests request);
    void deleteUser(String id);
}
