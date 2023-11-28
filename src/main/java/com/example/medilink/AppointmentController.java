package com.example.medilink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {

    private final ClinicService clinicService;
    private final SpecializationService specializationService;
    private final DoctorService doctorService;

    @Autowired
    public AppointmentController(ClinicService clinicService, SpecializationService specializationService, DoctorService doctorService) {
        this.clinicService = clinicService;
        this.specializationService = specializationService;
        this.doctorService = doctorService;
    }

    @GetMapping("/appointment")
    public String showAppointmentForm(Model model) {
        model.addAttribute("appointmentForm", new AppointmentServices());
        model.addAttribute("specializations", specializationService.getAllSpecializations());
        return "appointment";
    }

    @PostMapping("/appointment")
    public String submitAppointmentForm(@ModelAttribute("appointmentForm") AppointmentServices form) {
        // Вызов метода сервиса для планирования приема
        clinicService.scheduleAppointment(
                form.getPatientId(),
                form.getDoctorId(),
                form.getAppointmentDateTime(),
                form.getAppointmentType()
        );

        // Перенаправление на страницу успеха
        return "redirect:/success";
    }



    @ResponseBody
    @GetMapping("/doctors/{specializationId}")
    public List<Doctor> getDoctorsBySpecialization(@PathVariable int specializationId) {
        return doctorService.getDoctorsBySpecialization(specializationId);
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}
