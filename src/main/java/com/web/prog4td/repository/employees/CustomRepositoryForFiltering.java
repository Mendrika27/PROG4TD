package com.web.prog4td.repository.employees;

import com.web.prog4td.model.request.DatePlage;
import com.web.prog4td.model.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;


import java.util.List;

@Qualifier("EntityManagerFactoryEmployee")
public interface CustomRepositoryForFiltering {
    List<Employee> filterEmployee(String country_code, String lastName, String firstName, String birthday, DatePlage start, DatePlage leave, Integer sex);
}
