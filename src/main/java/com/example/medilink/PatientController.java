package com.example.medilink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/patient")
public class PatientController {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") @Valid Patient patient, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "patientForm"; // Возвращает пользователю страницу с формой для исправления ошибок
        }

        // Здесь можно провести дополнительные проверки перед сохранением пациента в базе данных

        patientRepository.save(patient); // Сохраняем пациента в базе данных

        return "redirect:/success"; // Перенаправляем на страницу с сообщением об успешном сохранении
    }

    // Дополнительный метод, который покажет страницу с успешным сообщением о сохранении пациента
    @RequestMapping("/success")
    public String showSuccessPage() {
        return "successPage";
    }
}
