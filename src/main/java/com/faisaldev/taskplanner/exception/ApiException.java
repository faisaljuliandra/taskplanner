package com.faisaldev.taskplanner.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiException {
    private final String type;
    private final String message;
}
