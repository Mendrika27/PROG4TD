package com.web.prog4td.Model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavePhoneNumber {
    private String value;
    private String country;
}
