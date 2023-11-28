package com.example.medilink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppointmentController {

    private final ClinicService clinicService;

    public AppointmentController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping("/appointment")
    public String showAppointmentForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "appointment"; // Имя представления (HTML-шаблона)
    }

    @PostMapping("/appointment")
    public String submitAppointmentForm(@ModelAttribute("patient") Patient patient) {
        clinicService.registerNewPatient(patient);
        return "success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}
