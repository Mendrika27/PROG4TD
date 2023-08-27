package com.web.prog4td.service;

import com.web.prog4td.model.request.DatePlage;
import com.web.prog4td.repository.employees.CustomRepositoryForFiltering;
import com.web.prog4td.repository.employees.EmployeeRepository;
import com.web.prog4td.mapper.EmployeeMapper;
import com.web.prog4td.model.entity.employee.Employee;
import com.web.prog4td.model.request.RequestedEmployee;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    private final PhoneNumberService phoneNumberService;
    private final CustomRepositoryForFiltering customRepositoryForFiltering;
    public List<RequestedEmployee> getAll(){
        return repository.findAll().stream().map(mapper::toRest).toList();
    }
    public RequestedEmployee getEmployeeByMatricule(String matricule){
        return mapper.toRest(repository.getEmployeeByMatricule(matricule));
    }
    public String saveEmployee(Employee employee){
        try{
            Employee tosave = repository.save(employee);
            phoneNumberService.UpadteAllEmployee(employee.getPhonenumber(), employee.getId());
            return "success";
        }
        catch (RuntimeException exception){
            throw exception;
        }
    }
    public List<RequestedEmployee> filterEmployee(
            @Nullable String CountryCode,
            @Nullable String lastName,
            @Nullable String firstName,
            @Nullable String birthday,
            @Nullable DatePlage start,
            @Nullable DatePlage end,
            @Nullable Integer sex
            ){
        return customRepositoryForFiltering.filterEmployee(CountryCode,lastName,firstName,birthday,start,end,sex).stream().map(mapper::toRest).toList();
    }
}
