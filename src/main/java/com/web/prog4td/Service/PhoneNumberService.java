package com.web.prog4td.Service;

import com.web.prog4td.Mapper.PhoneNumberMapper;
import com.web.prog4td.Repository.employees.PhoneNumberRepository;
import com.web.prog4td.Model.entity.employee.PhoneNumber;
import com.web.prog4td.Repository.employees.CountryCodeRepository;
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
