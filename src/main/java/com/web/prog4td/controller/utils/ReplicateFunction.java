package com.web.prog4td.controller.utils;

import com.web.prog4td.mpdel.entity.employee.User;
import com.web.prog4td.service.facade.EmployeeManagementFacade;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
public class ReplicateFunction {
    private final EmployeeManagementFacade facade;
    public boolean verify(HttpSession session){
        User identity = facade.authentifyUser(session);
        return identity==null;
    }
}
