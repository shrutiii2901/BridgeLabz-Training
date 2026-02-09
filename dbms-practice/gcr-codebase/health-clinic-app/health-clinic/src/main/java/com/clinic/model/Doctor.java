package com.clinic.model;

public class Doctor {

    private int doctorId;
    private String name;
    private int specialtyId;
    private String contact;
    private double consultationFee;
    private boolean isActive;

    public Doctor() {}

    // constructor used while adding
    public Doctor(String name, int specialtyId, String contact, double consultationFee) {
        this.name = name;
        this.specialtyId = specialtyId;
        this.contact = contact;
        this.consultationFee = consultationFee;
        this.isActive = true;
    }

    // getters & setters
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
