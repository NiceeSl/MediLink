package com.example.medilink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ClinicService {

    private final PatientDAO patientDAO;
    private final AppointmentDAO appointmentDAO;

    @Autowired
    public ClinicService(PatientDAO patientDAO, AppointmentDAO appointmentDAO) {
        this.patientDAO = patientDAO;
        this.appointmentDAO = appointmentDAO;
    }

    private boolean validatePatientData(Patient patient) {
        // Add your validation logic here
        // For example, check if the required fields are not null or empty
        if (patient.getFirstName() == null || patient.getFirstName().isEmpty()) {
            // Validation failed
            return false;
        }
        // Other validation rules...
        return true; // If data is valid
    }

    public void registerNewPatient(Patient patient) {
        validatePatientData(patient);
        patientDAO.addPatient(patient);
    }

    public void scheduleAppointment(int patientId, int doctorId, Timestamp appointmentDateTime, String appointmentType) {
        // Создание нового объекта приема
        MedicalAppointment appointment = new MedicalAppointment();
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDateAndTime(appointmentDateTime);
        appointment.setAppointmentType(appointmentType);

        // Сохранение приема в базе данных
        appointmentDAO.addAppointment(appointment);

    }


    // Other methods...
}