package com.web.prog4td.model.entity.employee;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String matricule;
    private String lastName;
    private Date birthDate;
    private byte[] photo;
    private SEX sex;
    private String address;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PhoneNumber> phonenumber;
    private String emailPerso;
    private int brutSalary;
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
