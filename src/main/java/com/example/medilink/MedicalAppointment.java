package com.example.medilink;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "MedicalAppointment")
public class MedicalAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int appointmentId;

    @Column(name = "patient_id")
    private int patientId;

    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "appointment_date_and_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp appointmentDateAndTime;

    @Column(name = "appointment_type")
    private String appointmentType;

    @Column(name = "appointment_status")
    private String appointmentStatus;


    public MedicalAppointment() {
        // Пустой конструктор нужен для Hibernate
    }

    public MedicalAppointment(int patientId, Timestamp appointmentDateAndTime, String appointmentStatus) {
        this.patientId = patientId;
        this.appointmentDateAndTime = appointmentDateAndTime;
        this.appointmentStatus = appointmentStatus;
    }

    // Геттеры и сеттеры для полей

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Timestamp getAppointmentDateAndTime() {
        return appointmentDateAndTime;
    }

    public void setAppointmentDateAndTime(Timestamp appointmentDateAndTime) {
        this.appointmentDateAndTime = appointmentDateAndTime;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
