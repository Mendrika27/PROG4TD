package com.web.prog4td.Controller.views;

import com.web.prog4td.Controller.utils.UserInformation;
import com.web.prog4td.Model.request.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthentificationViewsController {
    @GetMapping("/createUser")
    public String GetCreateUser(Model model){
        UserLogin toCreate = new UserLogin();
        model.addAttribute("newUser",toCreate);
        return "createUser";
    }
    @GetMapping("/login")
    public String GetLoginPage(Model model){
        UserInformation toSave = new UserInformation();
        model.addAttribute("userDetails",toSave);
        return "login";
    }
}
