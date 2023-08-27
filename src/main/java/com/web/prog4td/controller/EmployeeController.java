package com.web.prog4td.controller;

import com.lowagie.text.DocumentException;
import com.web.prog4td.controller.utils.ReplicateFunction;
import com.web.prog4td.controller.utils.UserInformation;
import com.web.prog4td.model.entity.employee.User;
import com.web.prog4td.model.request.SaveEmployee;
import com.web.prog4td.model.request.UserLogin;
import com.web.prog4td.service.facade.EmployeeManagementFacade;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@AllArgsConstructor
@Setter
@Getter
public class EmployeeController {
    private final EmployeeManagementFacade facade;
    private final ReplicateFunction replicate;
    private final String redirection = "redirect:/login";
    @GetMapping("/")
    public String test() throws IOException{
        return "redirect:/login";
    }
    @PostMapping("/new")
    public String createUser(@ModelAttribute("newUser") UserLogin user) throws IOException{
        facade.SignIn(user);
        return "redirect:/login";
    }
    @GetMapping("/authentification")
    public String AuthentifyUser(@ModelAttribute("userDetails") @Nullable UserInformation details, HttpSession session){
        if(details==null){
            return "redirect:/login";
        }
        User identity = facade.SignUp(details,session);
        if(identity==null){
            return "redirect:/login";
        }
        return "redirect:/employees";
    }
    @GetMapping("/pdf")
    public String getPdf(@RequestParam String employee, HttpServletResponse response,HttpSession session) throws DocumentException,IOException {
        if(replicate.verify(session)){
            return "redirect:/login";
        }
        facade.getPdf(employee,response.getOutputStream());
        return null;
    }
    @PostMapping("/save")
    public String Save(@ModelAttribute("employee") SaveEmployee employee, HttpSession session, User user) throws IOException,Exception{
        if(replicate.verify(session)){
            return "redirect:/login";
        }
        System.out.println(employee.getCountryCode());
        facade.ManageEmployee(employee);
        return "redirect:/employees";
    }
}
