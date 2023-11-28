package com.example.medilink;

import java.sql.Timestamp;

public class AppointmentServices {
    private int patientId;
    private int doctorId;
    private Timestamp appointmentDateTime;
    private String appointmentType;

    public AppointmentServices() {
    }

    public AppointmentServices(int patientId, int doctorId, Timestamp appointmentDateTime, String appointmentType) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.appointmentType = appointmentType;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Timestamp getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Timestamp appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }
}
