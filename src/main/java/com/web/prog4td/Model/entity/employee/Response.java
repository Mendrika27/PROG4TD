package com.web.prog4td.Model.entity.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    @Id
    private String id;
    @Column(columnDefinition = "text")
    private String value;
}
