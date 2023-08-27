package com.web.prog4td.service;

import com.web.prog4td.controller.utils.UserInformation;
import com.web.prog4td.model.entity.employee.User;
import com.web.prog4td.repository.employees.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Aspect
@Setter
@Getter
@AllArgsConstructor
public class SecurityService {
    private final UsersRepository repository;

    public User authentifyUserOnLogin(UserInformation detail){
        User test =  repository.getUserByUsernameAndPassword(detail.getUserName(),detail.getPassword());
        return test;
    }
    public void setTokenSession(User user, HttpSession session){
        String token = UUID.randomUUID().toString();
        session.setAttribute("JSESSIONID",token);
        repository.updateUserToken(token, user.getPassword());
    }
    public User AuthentifyUser(HttpSession session){
        Object UserToken = session.getAttribute("JSESSIONID");
        if (UserToken==null){
            System.out.println("no token");
            return null;
        }
        return repository.getUserByToken(UserToken.toString());
    }
    public User saveUser(User input){
        return repository.save(input);
    }
}
