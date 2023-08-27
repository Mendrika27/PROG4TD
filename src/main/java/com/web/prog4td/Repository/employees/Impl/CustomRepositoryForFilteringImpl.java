package com.web.prog4td.Repository.employees.Impl;

import com.web.prog4td.Model.request.DatePlage;
import com.web.prog4td.Model.entity.employee.Employee;
import com.web.prog4td.Repository.employees.CustomRepositoryForFiltering;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class CustomRepositoryForFilteringImpl implements CustomRepositoryForFiltering  {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> filterEmployee(String country_code, String lastName, String firstName, String birthday, DatePlage start, DatePlage end, Integer sex) {
        String MyQuery = this.createSuitableQueryForFiltering(country_code,lastName,firstName,birthday,start,end,sex);
        Query query = entityManager.createNativeQuery(MyQuery, Employee.class);
        if(sex!=null){
            query.setParameter("sex",sex);
        }
        List<Employee> employees = query.getResultList();
        return employees;
    }
    private String createSuitableQueryForFiltering(String country_code, String lastName, String firstName, String birthday, DatePlage start, DatePlage end, Integer sex){
        AtomicBoolean added = new AtomicBoolean(false);
        StringBuilder output = new StringBuilder();
        System.out.println(country_code);
        if(country_code!=null){
            output.append("SELECT e.* FROM employee e JOIN phonenumber p on e.id=p.user_id JOIN countrycode c on p.countrycode_id=c.id WHERE c.code ='").append(country_code).append("'");
            added.set(true);
            System.out.println("different de null");
        }else {
            output.replace(0,output.length(),"SELECT e.* FROM employee e WHERE ");
        }
        ConditionBlock before = ()->{
            if(added.get()){
                output.append(" AND ");
            }
            else{
                added.set(true);
            }
        };
        IfWithCondition(
                lastName!=null,
                ()->{output.append("lastname like '%").append(lastName).append("%'");},
                before
        );
        IfWithCondition(
                firstName!=null,
                ()->{output.append("firstname like '%").append(firstName).append("%'");},
                before
        );
        IfWithCondition(
                birthday!=null,
                ()->{output.append("birthdate = '").append(birthday).append("'");},
                before
        );
        IfWithCondition(
                sex!=null,
                ()->{output.append("sex = :sex");},
                before
        );
        IfWithCondition(
                start!=null,
                ()->{
                    output.append("dateentre BETWEEN '").append(start.getFrom()).append("' AND '").append(start.getTo()).append("'");},
                before
        );
        IfWithCondition(
                end!=null,
                ()->{output.append("dateentre BETWEEN '").append(end.getFrom()).append("' AND '").append(end.getTo()).append("'");},
                before
        );

        System.out.println(output.toString());
        return output.toString();
    }

    @FunctionalInterface
    private interface ConditionBlock {
        void execute();
    }

    private void IfWithCondition(boolean condition,ConditionBlock conditionBlock,ConditionBlock before){
        if(condition){
            before.execute();
            conditionBlock.execute();
        }
    }
}
