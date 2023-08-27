package com.web.prog4td.Repository.employees;

import com.web.prog4td.Model.request.DatePlage;
import com.web.prog4td.Model.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.List;

@Qualifier("EntityManagerFactoryEmployee")
public interface CustomRepositoryForFiltering {
    List<Employee> filterEmployee(String country_code, String lastName, String firstName, String birthday, DatePlage start, DatePlage leave, Integer sex);
}
