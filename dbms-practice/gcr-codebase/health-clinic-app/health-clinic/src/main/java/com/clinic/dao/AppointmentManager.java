package com.clinic.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.clinic.config.DBConnection;
import com.clinic.model.Appointment;

public class AppointmentManager {

    // UC-3.1 Book
    public void bookAppointment(Appointment a) throws Exception {

        String check = "SELECT COUNT(*) FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=?";
        String insert = "INSERT INTO appointments(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES (?,?,?,?, 'SCHEDULED')";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, a.getDoctorId());
            ps.setDate(2, a.getAppointmentDate());
            ps.setTime(3, a.getAppointmentTime());

            ResultSet rs = ps.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Slot not available.");
                return;
            }

            PreparedStatement ps2 = con.prepareStatement(insert);
            ps2.setInt(1, a.getPatientId());
            ps2.setInt(2, a.getDoctorId());
            ps2.setDate(3, a.getAppointmentDate());
            ps2.setTime(4, a.getAppointmentTime());
            ps2.executeUpdate();

            System.out.println("Appointment booked.");
        }
    }

    // UC-3.3 Cancel
    public void cancelAppointment(int appointmentId) throws Exception {

        String update = "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?";
        String audit = "INSERT INTO appointment_audit(appointment_id, action, action_time) VALUES (?, 'CANCELLED', NOW())";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(update);
            ps1.setInt(1, appointmentId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(audit);
            ps2.setInt(1, appointmentId);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Cancelled successfully.");
        }
    }

    // UC-3.5 Daily Schedule
    public void getDailySchedule(Date date) throws Exception {

        String sql = """
                SELECT a.appointment_time, p.name, d.name
                FROM appointments a
                JOIN patients p ON a.patient_id = p.patient_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                WHERE appointment_date=?
                ORDER BY appointment_time
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getTime(1) + " | " +
                        rs.getString(2) + " | " +
                        rs.getString(3));
            }
        }
    }
}
