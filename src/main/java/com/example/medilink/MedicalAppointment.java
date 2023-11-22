package com.example.medilink;

import java.sql.Timestamp;

public class MedicalAppointment {
    private int appointmentId;
    private Timestamp appointmentDateAndTime;
    private String appointmentStatus;

    public MedicalAppointment(int appointmentId, Timestamp appointmentDateAndTime, String appointmentStatus) {
        this.appointmentId = appointmentId;
        this.appointmentDateAndTime = appointmentDateAndTime;
        this.appointmentStatus = appointmentStatus;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Timestamp getAppointmentDateAndTime() {
        return appointmentDateAndTime;
    }

    public void setAppointmentDateAndTime(Timestamp appointmentDateAndTime) {
        this.appointmentDateAndTime = appointmentDateAndTime;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
