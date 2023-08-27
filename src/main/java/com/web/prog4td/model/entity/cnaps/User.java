package com.web.prog4td.model.entity.cnaps;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class user {
    @Id
    private String id;
}
