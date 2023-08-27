package com.web.prog4td.Model.request;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestedCompanyInformation {
    private String companyName;
    private String companySlogan;
    private String companyLogo;
    private String nif;
    private String stat;
    private String email;
    private String address;
    private String number;
}
