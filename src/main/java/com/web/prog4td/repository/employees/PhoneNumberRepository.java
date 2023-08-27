package com.web.prog4td.repository.employees;

import com.web.prog4td.model.entity.employee.PhoneNumber;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Qualifier("EntityManagerFactoryEmployee")
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber,String> {
    List<PhoneNumber> getPhoneNumbersByValue(String value);
    @Modifying
    @Transactional
    @Query(value = "update phonenumber set user_id = :id where id = :phoneNumberId",nativeQuery = true)
    void setEmployee(String id,String phoneNumberId);
}
