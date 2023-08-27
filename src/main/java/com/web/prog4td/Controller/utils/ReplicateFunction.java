package com.web.prog4td.Controller.utils;

import com.web.prog4td.Model.entity.employee.User;
import com.web.prog4td.Service.facade.EmployeeManagementFacade;
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
