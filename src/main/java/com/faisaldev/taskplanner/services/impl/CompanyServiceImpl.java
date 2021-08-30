package com.faisaldev.taskplanner.services.impl;

import com.faisaldev.taskplanner.dtos.requests.CompanyRequests;
import com.faisaldev.taskplanner.dtos.responses.CompanyResponses;
import com.faisaldev.taskplanner.exception.ErrorException;
import com.faisaldev.taskplanner.models.Companies;
import com.faisaldev.taskplanner.repositories.CompanyRepository;
import com.faisaldev.taskplanner.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public void addCompany(CompanyRequests request) {
        Companies companyName =companyRepository.findByName(request.getName());

        if (companyName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        Companies companies = new Companies();
        companies.setName(request.getName());
        companyRepository.save(companies);
    }

    @Override
    public List<CompanyResponses> getAllCompanies() {
        List<Companies> companies = companyRepository.findAll();
        return companies
                .stream()
                .map(result -> CompanyResponses
                        .builder()
                        .id(result.getId())
                        .name(result.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponses searchByName(String name) {
        Companies companies = companyRepository.findByName(name);

        return CompanyResponses.builder()
                .id(companies.getId())
                .name(companies.getName())
                .build();
    }

    @Override
    public void updateCompany(String id, CompanyRequests request) {
        Companies companyName =companyRepository.findByName(request.getName());
        Companies companies = companyRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Company not found!", HttpStatus.NOT_FOUND));

        if (companyName != null) {
            throw new ErrorException("Company already exists", HttpStatus.CONFLICT);
        }
        companies.setName(request.getName());
        companyRepository.save(companies);
    }

    @Override
    public void deleteCompany(String id) {
        Companies companies = companyRepository.findById(id)
                .orElseThrow(() -> new ErrorException("Company not found!", HttpStatus.NOT_FOUND));
        companyRepository.delete(companies);
    }
}
