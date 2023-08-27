package com.web.prog4td.Model.request;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveCompanyInformation {
    private String name;
    private String slogan;
    private String nif;
    private String stat;
    @Column(length = 10)
    private String number;
    private String address;
    private String email;
}
