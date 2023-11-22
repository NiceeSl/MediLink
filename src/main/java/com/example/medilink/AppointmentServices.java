package com.example.medilink;

public class AppointmentServices {
    private int appointmentId;
    private int serviceId;

    public AppointmentServices(int appointmentId, int serviceId) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
