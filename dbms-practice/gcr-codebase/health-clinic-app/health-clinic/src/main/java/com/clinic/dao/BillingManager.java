package com.clinic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.clinic.config.DBConnection;
import com.clinic.model.Bill;
import com.clinic.model.PaymentTransaction;

public class BillingManager {

    // UC-5.2 Record Payment
    public void recordPayment(PaymentTransaction pt) throws Exception {

        String update = "UPDATE bills SET payment_status='PAID' WHERE bill_id=?";
        String txn = "INSERT INTO payment_transactions(bill_id, payment_date, payment_mode) VALUES (?, NOW(), ?)";

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(update);
            ps1.setInt(1, pt.getBillId());
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(txn);
            ps2.setInt(1, pt.getBillId());
            ps2.setString(2, pt.getPaymentMode());
            ps2.executeUpdate();

            con.commit();
            System.out.println("Payment recorded.");
        }
    }

    // UC-5.3 Outstanding Bills
    public List<Bill> getUnpaidBills() throws Exception {

        List<Bill> list = new ArrayList<>();

        String sql = "SELECT bill_id, total_amount, payment_status FROM bills WHERE payment_status='UNPAID'";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Bill b = new Bill();
                b.setBillId(rs.getInt("bill_id"));
                b.setTotalAmount(rs.getDouble("total_amount"));
                b.setPaymentStatus(rs.getString("payment_status"));
                list.add(b);
            }
        }

        return list;
    }
}
