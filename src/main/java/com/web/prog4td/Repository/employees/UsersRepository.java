package com.web.prog4td.Repository.employees;

import com.web.prog4td.Model.entity.employee.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("EntityManagerFactoryEmployee")
public interface UsersRepository extends JpaRepository<User,String> {
    User getUserByToken(String token);
    User getUserByUsernameAndPassword(String username, String password);
    @Modifying
    @Query(nativeQuery = true, value = "update \"user\" set token=:token where password=:password")
    @Transactional
    void updateUserToken(String token,String password);
}