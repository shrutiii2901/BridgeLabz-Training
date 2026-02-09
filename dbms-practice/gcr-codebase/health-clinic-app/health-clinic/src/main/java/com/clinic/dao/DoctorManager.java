package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.clinic.config.DBConnection;
import com.clinic.model.Doctor;

public class DoctorManager {

    // UC-2.1 Add Doctor
   public void addDoctor(Doctor d) throws Exception {

    String sql = "INSERT INTO doctors(name, specialty_id, contact, consultation_fee, is_active) VALUES (?,?,?,?,true)";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, d.getName());
        ps.setInt(2, d.getSpecialtyId());
        ps.setString(3, d.getContact()); 
        ps.setDouble(4, d.getConsultationFee());

        ps.executeUpdate();
        System.out.println("Doctor added successfully.");
    }
}


    // UC-2.2 Update Specialty
    public void updateDoctorSpecialty(int doctorId, int specialtyId) throws Exception {
        String sql = "UPDATE doctors SET specialty_id=? WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);
            ps.setInt(2, doctorId);

            ps.executeUpdate();
            System.out.println("Specialty updated.");
        }
    }

    // UC-2.3 View Doctors by Specialty
    public void getDoctorsBySpecialty(String specialty) throws Exception {

        String sql = """
                SELECT d.doctor_id, d.name, d.contact
                FROM doctors d
                JOIN specialties s ON d.specialty_id = s.specialty_id
                WHERE s.name = ? AND d.is_active = true
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("doctor_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("contact"));
            }
        }
    }

    // UC-2.4 Deactivate
    public void deactivateDoctor(int doctorId) throws Exception {

        String check = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date >= CURDATE()";
        String update = "UPDATE doctors SET is_active=false WHERE doctor_id=?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Cannot deactivate. Future appointments exist.");
                return;
            }

            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setInt(1, doctorId);
            ps2.executeUpdate();

            System.out.println("Doctor deactivated.");
        }
    }
}
