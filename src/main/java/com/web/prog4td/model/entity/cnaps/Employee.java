package com.web.prog4td.model.entity.cnaps;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private byte[] photo;
    private com.web.prog4td.Model.entity.employee.Employee.SEX sex;
    private String address;
    private String emailPerso;
    private String emailPro;
    private String cinNumber;
    private Date dateEntre;
    private Date dateSortie;
    private String cinCreationDate;
    private String cnaps;
    public enum SEX{
        H,F
    }
}
