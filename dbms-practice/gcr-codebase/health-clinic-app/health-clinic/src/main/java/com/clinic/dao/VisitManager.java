package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.clinic.config.DBConnection;
import com.clinic.model.Visit;

public class VisitManager {

    // UC-4.1 Record Visit
    public void recordVisit(Visit v) throws Exception {

        String visit = "INSERT INTO visits(appointment_id, diagnosis, notes, visit_date) VALUES (?,?,?, NOW())";
        String update = "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(visit);
            ps1.setInt(1, v.getAppointmentId());
            ps1.setString(2, v.getDiagnosis());
            ps1.setString(3, v.getNotes());
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(update);
            ps2.setInt(1, v.getAppointmentId());
            ps2.executeUpdate();

            con.commit();
            System.out.println("Visit recorded.");
        }
    }

    // UC-4.3 Add Prescriptions
    public void addPrescriptions(int visitId, List<String> medicines) throws Exception {

        String sql = "INSERT INTO prescriptions(visit_id, medicine) VALUES (?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (String med : medicines) {
                ps.setInt(1, visitId);
                ps.setString(2, med);
                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Prescriptions added.");
        }
    }
}
