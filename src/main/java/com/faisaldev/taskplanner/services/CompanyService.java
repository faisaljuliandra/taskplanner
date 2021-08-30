package com.faisaldev.taskplanner.services;

import com.faisaldev.taskplanner.dtos.requests.CompanyRequests;
import com.faisaldev.taskplanner.dtos.responses.CompanyResponses;

import java.util.List;

public interface CompanyService {
    void addCompany(CompanyRequests request);
    List<CompanyResponses> getAllCompanies();
    CompanyResponses searchByName(String name);
    void updateCompany(String id, CompanyRequests request);
    void deleteCompany(String id);
}
