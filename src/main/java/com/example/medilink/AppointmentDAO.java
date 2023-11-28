package com.example.medilink;


import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class AppointmentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addAppointment(MedicalAppointment appointment) {
        entityManager.persist(appointment);
    }

    public List<MedicalAppointment> getAppointmentsForPatient(int patientId) {
        try {
            TypedQuery<MedicalAppointment> query = entityManager.createQuery("FROM MedicalAppointment WHERE patient_id = :patientId", MedicalAppointment.class);
            query.setParameter("patientId", patientId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch appointments for the patient from the database.", e);
        }
    }
}
