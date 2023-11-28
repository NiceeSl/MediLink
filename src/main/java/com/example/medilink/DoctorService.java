package com.example.medilink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getDoctorsBySpecialization(int specializationId) {
        return doctorRepository.findBySpecialization_SpecializationId(specializationId);
    }
}
