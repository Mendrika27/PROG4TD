package com.web.prog4td.model.request;

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
