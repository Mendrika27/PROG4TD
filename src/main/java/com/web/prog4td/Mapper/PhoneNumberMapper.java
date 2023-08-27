package com.web.prog4td.Mapper;

import com.web.prog4td.Model.entity.employee.CountryCode;
import com.web.prog4td.Model.entity.employee.PhoneNumber;
import com.web.prog4td.Model.request.SavePhoneNumber;
import com.web.prog4td.Repository.employees.CountryCodeRepository;
import com.web.prog4td.Repository.employees.PhoneNumberRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
@Getter
@Setter
public class PhoneNumberMapper {
    private final CountryCodeRepository countryCodeRepository;
    private final PhoneNumberRepository phoneNumberRepository;
    public PhoneNumber toEntity(SavePhoneNumber input,String countryCode){
        Optional<CountryCode> tosave = countryCodeRepository.findById(countryCode);
        return tosave.isPresent() ? (PhoneNumber.builder()
                .id(UUID.randomUUID().toString())
                .countryCode(tosave.get())
                .value(input.getValue())
                .build()) : (new PhoneNumber());
    }
    public SavePhoneNumber toSavePhoneNumber(String phone, String countryCode){
        Optional<CountryCode> code = countryCodeRepository.findById(countryCode);
        if(code.isPresent()){
            List<PhoneNumber> toTest = phoneNumberRepository.getPhoneNumbersByValue(phone);
            toTest.forEach(phoneNumber ->{
                System.out.println(phoneNumber.getValue()+" and "+phone);
                System.out.println(phoneNumber.getCountryCode().getCode()+" and "+code.get().getCode());
                if(phoneNumber.getValue().equals(phone) && phoneNumber.getCountryCode().getCode().equals(code.get().getCode())){
                    throw new RuntimeException();
                }
            });
        }
        return SavePhoneNumber.builder()
                .country(countryCode)
                .value(phone)
                .build();
    }
}
