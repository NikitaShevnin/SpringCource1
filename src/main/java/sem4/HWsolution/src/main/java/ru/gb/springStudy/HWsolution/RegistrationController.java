package ru.gb.springStudy.HWsolution;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute RegistrationForm registrationForm) {
        // Обработка полученных данных формы
        System.out.println("Name: " + registrationForm.getName());
        System.out.println("Email: " + registrationForm.getEmail());
        return "registration-success";
    }
}
