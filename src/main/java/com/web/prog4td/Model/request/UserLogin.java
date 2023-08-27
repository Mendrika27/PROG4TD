package com.web.prog4td.Model.request;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    private String userName;
    private String password;
}
