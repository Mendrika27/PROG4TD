package com.web.prog4td.model.request;

import com.web.prog4td.model.entity.employee.Employee;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveEmployee {
    private String firstName;
    private int brutSalary;
    private String lastName;
    private String birthDate;
    private MultipartFile photo;
    private Employee.SEX sex;
    private String countryCode;
    private String date_entre;
    private String date_sortie;
    private String address;
    private String phoneNumber;
    private String emailPerso;
    private String emailPro;
    private String cinNumber;
    private String cinCreationDate;
    private String cnaps;
}
