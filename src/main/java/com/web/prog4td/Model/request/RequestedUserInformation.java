package com.web.prog4td.Model.request;

import com.web.prog4td.Model.entity.employee.User;
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
