package com.web.prog4td.service;

import com.web.prog4td.mapper.PhoneNumberMapper;
import com.web.prog4td.repository.employees.PhoneNumberRepository;
import com.web.prog4td.model.entity.employee.PhoneNumber;
import com.web.prog4td.repository.employees.CountryCodeRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class PhoneNumberService {
    private final PhoneNumberRepository repository;
    private final PhoneNumberMapper phoneNumberMapper;
    private final CountryCodeRepository countryCodeRepository;

    public void UpadteAllEmployee(List<PhoneNumber> phoneNumberList, String EmployeeId){
        phoneNumberList.forEach(phoneNumber -> {
                    repository.setEmployee(EmployeeId, phoneNumber.getId());
                }
        );
    }
}
