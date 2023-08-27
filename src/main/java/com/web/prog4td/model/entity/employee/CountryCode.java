package com.web.prog4td.model.entity.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryCode {
    @Id
    private String id;
    private String code;
    @OneToMany(mappedBy = "countryCode")
    @JsonIgnore
    private List<PhoneNumber> phoneNumber;
}
