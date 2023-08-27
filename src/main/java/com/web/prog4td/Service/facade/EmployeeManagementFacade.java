package com.web.prog4td.Service.facade;

import com.lowagie.text.DocumentException;
import com.web.prog4td.Controller.utils.InputFormat;
import com.web.prog4td.Controller.utils.UserInformation;
import com.web.prog4td.Model.entity.employee.User;
import com.web.prog4td.Model.request.RequestedEmployee;
import com.web.prog4td.Model.request.SaveEmployee;
import com.web.prog4td.Model.request.UserLogin;
import com.web.prog4td.Repository.employees.CountryCodeRepository;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.List;


public interface EmployeeManagementFacade {
    List<RequestedEmployee> listAllEmployee(InputFormat by);
    User SignUp(UserInformation input, HttpSession session);

    User SignIn(UserLogin input);
    String ManageEmployee(SaveEmployee input) throws IOException;
    RequestedEmployee getEmployeeDetails(String matricule);
    CountryCodeRepository getcountryCodeInstance();
    User authentifyUser(HttpSession input);
    void getPdf(String user, OutputStream outputStream) throws DocumentException, IOException;
}
