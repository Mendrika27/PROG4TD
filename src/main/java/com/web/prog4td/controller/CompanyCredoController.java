package com.web.prog4td.controller;

import com.web.prog4td.model.request.SaveCompanyInformation;
import com.web.prog4td.repository.employees.CompanyInformationRepository;
import com.web.prog4td.model.entity.employee.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.UUID;

@Controller
@AllArgsConstructor
@Setter
@Getter
public class CompanyCredoController {
    private final CompanyInformationRepository repository;
    @PostMapping("/company/save")
    public String save(@ModelAttribute("company") SaveCompanyInformation input) throws IOException {
        Company tosave = Company.builder()
                .name(input.getName())
                .id(UUID.randomUUID().toString())
                .nif(input.getNif())
                .number(input.getNumber())
                .stat(input.getStat())
                .address(input.getAddress())
                .email(input.getEmail())
                .slogan(input.getSlogan())
                .build();
        repository.save(tosave);
        return "redirect:/login";
    }
    @GetMapping("/company")
    public String getPage(Model model){
        SaveCompanyInformation input = new SaveCompanyInformation();
        model.addAttribute("company",input);
        return "company";
    }
}
