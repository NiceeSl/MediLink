package com.example.medilink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpecializationApiController {

    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/specializations")
    public List<Specialization> getAllSpecializations() {
        return specializationService.getAllSpecializations();
    }
}
