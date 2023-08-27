package com.web.prog4td.repository.cnaps;

import com.web.prog4td.model.entity.cnaps.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CnapsEmployeeRepository")
@Qualifier("EntityManagerFactoryCnaps")
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    Employee getEmployeeByCnaps(String cnaps);
}
