package com.web.prog4td.Model.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Company {
    @Id
    private String id;
    private String name;
    private String slogan;
    private String nif;
    private String number;
    private String stat;
    private String address;
    private String email;
}
