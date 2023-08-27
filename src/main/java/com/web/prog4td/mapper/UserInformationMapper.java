package com.web.prog4td.mapper;

import com.web.prog4td.model.entity.employee.User;
import com.web.prog4td.model.request.UserLogin;
import com.web.prog4td.model.request.RequestedUserInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Getter
@Setter
public class UserInformationMapper {
    public User toEntity(UserLogin input){
        return User.builder()
                .password(input.getPassword())
                .username(input.getUserName())
                .id(UUID.randomUUID().toString()).build();
    }

    public RequestedUserInformation toRest(User input) {
        return RequestedUserInformation.builder()
                .role(input.getRole())
                .userName(input.getUsername())
                .token(input.getToken())
                .build();
    }
}
