package com.example.medilink;

public class MedicalService {
    private int serviceId;
    private String serviceName;
    private String description;
    private int cost;

    public MedicalService(int serviceId, String serviceName, String description, int cost) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.cost = cost;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
