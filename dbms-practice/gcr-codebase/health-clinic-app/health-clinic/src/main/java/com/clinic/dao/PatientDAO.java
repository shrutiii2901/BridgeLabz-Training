package com.clinic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DBConnection;
import com.clinic.model.Patient;

public class PatientDAO {

    // UC-1.1 Register
    public void addPatient(Patient p) throws Exception {
        String sql = "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getName());
            ps.setDate(2, Date.valueOf(p.getDob()));
            ps.setString(3, p.getPhone());
            ps.setString(4, p.getEmail());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getBloodGroup());

            ps.executeUpdate();
            System.out.println("Patient registered successfully.");
        }
    }

    // UC-1.2 Update
    public void updatePatient(int id, String address) throws Exception {
        String sql = "UPDATE patients SET address=? WHERE patient_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, address);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Updated successfully");
            else
                System.out.println("Patient not found");
        }
    }

    // UC-1.3 Search
    public List<Patient> searchByName(String name) throws Exception {
        String sql = "SELECT * FROM patients WHERE name LIKE ?";
        List<Patient> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                list.add(p);
            }
        }
        return list;
    }

    // UC-1.4 Visit History
    public void getVisitHistory(int patientId) throws Exception {
        String sql = """
                SELECT v.visit_date, v.diagnosis, d.name AS doctor_name
                FROM visits v
                JOIN appointments a ON v.appointment_id = a.appointment_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE a.patient_id = ?
                ORDER BY v.visit_date
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getTimestamp("visit_date") + " | " +
                        rs.getString("doctor_name") + " | " +
                        rs.getString("diagnosis")
                );
            }
        }
    }
}
