package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DBConnection;
import com.clinic.model.Specialty;

public class AdminManager {

    // CREATE
    public void addSpecialty(Specialty s) throws Exception {
        String sql = "INSERT INTO specialties(name, description) VALUES (?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getDescription());
            ps.executeUpdate();

            System.out.println("Specialty added.");
        }
    }

    // READ
    public List<Specialty> getAllSpecialties() throws Exception {
        String sql = "SELECT * FROM specialties";
        List<Specialty> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Specialty s = new Specialty();
                s.setSpecialtyId(rs.getInt("specialty_id"));
                s.setName(rs.getString("name"));
                s.setDescription(rs.getString("description"));
                list.add(s);
            }
        }
        return list;
    }

    // UPDATE
    public void updateSpecialty(Specialty s) throws Exception {
        String sql = "UPDATE specialties SET name=?, description=? WHERE specialty_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getDescription());
            ps.setInt(3, s.getSpecialtyId());

            ps.executeUpdate();
            System.out.println("Updated successfully.");
        }
    }

    // DELETE with FK safety
    public void deleteSpecialty(int id) throws Exception {

        String check = "SELECT COUNT(*) FROM doctors WHERE specialty_id=?";
        String delete = "DELETE FROM specialties WHERE specialty_id=?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                System.out.println("Cannot delete. Specialty used by doctors.");
                return;
            }

            PreparedStatement ps2 = con.prepareStatement(delete);
            ps2.setInt(1, id);
            ps2.executeUpdate();

            System.out.println("Deleted successfully.");
        }
    }
}
