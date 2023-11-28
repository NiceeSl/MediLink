package com.example.medilink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Repository
public class PatientDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void addPatient(Patient patient) {
        entityManager.persist(patient);
    }

    @Transactional
    public Patient getPatientById(int patientId) {
        return entityManager.find(Patient.class, patientId);
    }

    @Transactional
    public void deletePatient(int patientId) {
        Patient patientToDelete = entityManager.find(Patient.class, patientId);
        if (patientToDelete != null) {
            entityManager.remove(patientToDelete);
        }
    }

    @Transactional
    public void updatePatient(Patient patient) {
        entityManager.merge(patient);
    }

    @Transactional
    public List<Patient> getAllPatients() {
        Query query = entityManager.createQuery("from Patient", Patient.class);
        return query.getResultList();
    }
}
