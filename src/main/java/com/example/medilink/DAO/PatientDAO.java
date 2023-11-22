package com.example.medilink.DAO;

import com.example.medilink.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    private final Connection connection;

    public PatientDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patient (first_name, last_name, date_of_birth, address, phone, sex) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, new java.sql.Date(patient.getBirth().getTime()));
            statement.setString(4, patient.getAddress());
            statement.setString(5, patient.getPhone());
            statement.setString(6, patient.getSex());
            statement.executeUpdate();
        }
    }

    public Patient getPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM Patient WHERE patient_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Patient(
                            resultSet.getInt("patient_id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("date_of_birth"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getString("sex").charAt(0)
                    );
                }
            }
        }
        return null;
    }

    public void deletePatient(int patientId) throws SQLException {
        String sql = "DELETE FROM Patient WHERE patient_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, patientId);
            statement.executeUpdate();
        }
    }

    public void updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patient SET first_name = ?, last_name = ?, date_of_birth = ?, address = ?, phone = ?, sex = ? WHERE patient_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getLastName());
            statement.setDate(3, new java.sql.Date(patient.getBirth().getTime()));
            statement.setString(4, patient.getAddress());
            statement.setString(5, patient.getPhone());
            statement.setString(6, String.valueOf(patient.getSex()));
            statement.setInt(7, patient.getPatientId());
            statement.executeUpdate();
        }
    }
}