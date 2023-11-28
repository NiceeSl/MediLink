package com.example.medilink;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialization_id")
    private int specializationId;

    @Column(name = "specialization_name")
    private String specializationName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "specialization")
    @JsonManagedReference
    private Set<Doctor> doctors;

    // Конструкторы
    public Specialization() {
    }

    public Specialization(String specializationName, String description) {
        this.specializationName = specializationName;
        this.description = description;
    }

    // Геттеры и сеттеры
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

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    // Переопределение методов equals и hashCode
    // ...

    @Override
    public String toString() {
        return "Specialization{" +
                "specializationId=" + specializationId +
                ", specializationName='" + specializationName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
