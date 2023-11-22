package com.example.medilink;

public class Specialization {
    private int specializationId;
    private String specializationName;
    private String description;

    public Specialization(int specializationId, String specializationName, String description) {
        this.specializationId = specializationId;
        this.specializationName = specializationName;
        this.description = description;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
