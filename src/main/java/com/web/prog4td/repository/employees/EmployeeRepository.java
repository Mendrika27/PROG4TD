package com.web.prog4td.repository.employees;

import com.web.prog4td.model.entity.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("EntityManagerFactoryEmployee")
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee getEmployeeByMatricule(String matricule);
}
