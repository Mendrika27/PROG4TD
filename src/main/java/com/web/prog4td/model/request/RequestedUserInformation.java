package com.web.prog4td.model.request;

import com.web.prog4td.model.entity.employee.User;
import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestedUserInformation {
    private String userName;
    private String token;
    private User.ROLE role;
}
