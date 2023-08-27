package com.web.prog4td.service.facade.impl;

import com.lowagie.text.DocumentException;
import com.web.prog4td.controller.utils.InputFormat;
import com.web.prog4td.controller.utils.UserInformation;
import com.web.prog4td.mapper.EmployeeMapper;
import com.web.prog4td.model.entity.employee.Company;
import com.web.prog4td.model.entity.employee.User;
import com.web.prog4td.model.request.RequestedCompanyInformation;
import com.web.prog4td.model.request.RequestedEmployee;
import com.web.prog4td.model.request.SaveEmployee;
import com.web.prog4td.model.request.UserLogin;
import com.web.prog4td.repository.employees.CompanyInformationRepository;
import com.web.prog4td.repository.employees.CountryCodeRepository;
import com.web.prog4td.service.EmployeeService;
import com.web.prog4td.service.PDFGeneratingService;
import com.web.prog4td.service.SecurityService;
import com.web.prog4td.service.facade.EmployeeManagementFacade;
import com.web.prog4td.mapper.UserInformationMapper;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Base64;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Service
public class EmployeeManagementFacadeImpl implements EmployeeManagementFacade {
    private final EmployeeService service;
    private final SecurityService security;
    private final EmployeeMapper employeeMapper;
    private final CountryCodeRepository countryCodeRepository;
    private final CompanyInformationRepository companyInformationRepository;
    private final PDFGeneratingService pdfGeneratingService;
    private final UserInformationMapper userInformationMapper;
    @Override
    @Primary
    public List<RequestedEmployee> listAllEmployee(InputFormat by) {
        by.clean();
        if(by.IsEmpty()){
            return service.getAll();
        }else{
            return service.filterEmployee(by.getCountryCode(),by.getLastName(),by.getFirstName(),by.getBirthday(),by.getStart(),by.getEnd(),by.getSex());
        }
    }
    public User verifyUserSession(HttpSession session) throws IOException {
        return security.AuthentifyUser(session);
    }
    @Override
    @Primary
    public User SignUp(UserInformation input, HttpSession session) {
        User identity = security.authentifyUserOnLogin(input);
        if(identity!=null){
            security.setTokenSession(identity,session);
        }
        return identity;
    }

    @Override
    @Primary
    public User SignIn(UserLogin input) {
        return security.saveUser(userInformationMapper.toEntity(input));
    }

    @Override
    @Primary
    public String ManageEmployee(SaveEmployee input) throws IOException {
        return service.saveEmployee(employeeMapper.toEntity(input));
    }

    @Override
    @Primary
    public RequestedEmployee getEmployeeDetails(String matricule) {
        return service.getEmployeeByMatricule(matricule);
    }

    @Override
    @Primary
    public CountryCodeRepository getcountryCodeInstance() {
        return countryCodeRepository;
    }

    @Override
    public User authentifyUser(HttpSession input) {
        return security.AuthentifyUser(input);
    }

    @Override
    public void getPdf(String matricule, OutputStream outputStream) throws DocumentException, IOException {
        Company company = companyInformationRepository.findAll().get(0);
        RequestedCompanyInformation insert = RequestedCompanyInformation.builder()
                .companyName(company.getName())
                .nif(company.getNif())
                .number(company.getNumber())
                .stat(company.getStat())
                .address(company.getAddress())
                .email(company.getEmail())
                .companySlogan(company.getSlogan())
                .build();
        RequestedEmployee employee = service.getEmployeeByMatricule(matricule);
        String html = pdfGeneratingService.parseThymeleafTemplate(employee,insert);
        pdfGeneratingService.generatePdfFromHtml(html,outputStream);
    }
}
