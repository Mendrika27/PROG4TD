package com.web.prog4td.controller;

import com.web.prog4td.model.entity.employee.CountryCode;
import com.web.prog4td.model.request.DatePlage;
import com.web.prog4td.repository.employees.CustomRepositoryForFiltering;
import com.web.prog4td.model.entity.employee.Employee;
import com.web.prog4td.model.request.RequestedEmployee;
import com.web.prog4td.repository.employees.CountryCodeRepository;
import com.web.prog4td.service.EmployeeService;
import com.web.prog4td.service.facade.EmployeeManagementFacade;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class test {
    private final EmployeeService service;
    private final CountryCodeRepository repository;
    private final CustomRepositoryForFiltering custom;
    private final EmployeeManagementFacade facade;
    @GetMapping("/test")
    public List<RequestedEmployee> get(){
        return service.getAll();
    }
    @GetMapping("/phone")
    public List<CountryCode> getl(){
        return repository.findAll();
    }
    @GetMapping("/test/filtered")
    public List<Employee> anotherTest(
            @Nullable @RequestParam("lastname") String lastName,
            @Nullable @RequestParam("firstname") String firstName,
            @Nullable @RequestParam("birthday") String birthday,
            @Nullable @RequestParam("start") DatePlage start,
            @Nullable @RequestParam("end") DatePlage end,
            @Nullable @RequestParam("sex") Integer sex
    ){
        return custom.filterEmployee("asd",lastName,firstName,birthday,start,end,sex);
    }
}
