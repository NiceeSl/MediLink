package com.example.medilink;

import com.example.medilink.DAO.PatientDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class PatientDAOTest {
    public static void main(String[] args) {
        // Создание подключения к базе данных
        Connection connection = DatabaseConnection.getConnection();

        // Создание экземпляра DAO
        PatientDAO patientDAO = new PatientDAO(connection);

        try {
            // Добавление нового пациента
            Patient newPatient = new Patient(0, "Иван", "Иванов", new java.sql.Date(System.currentTimeMillis()), "123 Street", "1234567890", 'M');
            patientDAO.addPatient(newPatient);
            System.out.println("Пациент добавлен.");

            // Получение и вывод информации о пациенте
            Patient retrievedPatient = patientDAO.getPatientById(1); // Предполагается, что такой ID существует
            if (retrievedPatient != null) {
                System.out.println("Получен пациент: " + retrievedPatient.getFirstName() + " " + retrievedPatient.getLastName());
            }

            // Обновление информации о пациенте
            assert retrievedPatient != null;
            retrievedPatient.setPhone("0987654321");
            patientDAO.updatePatient(retrievedPatient);
            System.out.println("Информация о пациенте обновлена.");

            // Удаление пациента
            patientDAO.deletePatient(1); // Предполагается, что такой ID существует
            System.out.println("Пациент удален.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}