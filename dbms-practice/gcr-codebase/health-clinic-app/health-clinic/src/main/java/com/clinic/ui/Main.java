package com.clinic.ui;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.clinic.dao.*;
import com.clinic.model.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        PatientDAO patient = new PatientDAO();
        DoctorManager doctor = new DoctorManager();
        AppointmentManager appointment = new AppointmentManager();
        VisitManager visit = new VisitManager();
        BillingManager billing= new BillingManager();
        AdminManager admin = new AdminManager();

        while (true) {

            System.out.println("\nCLINIC MANAGEMENT SYSTEM");
            System.out.println("1. Patient");
            System.out.println("2. Doctor");
            System.out.println("3. Appointment");
            System.out.println("4. Visit");
            System.out.println("5. Billing");
            System.out.println("6. Specialty Admin");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                // PATIENT 
                case 1:
                    System.out.println("\n1.Register\n2.Update Address\n3.Search\n4.History");
                    int pch = sc.nextInt();

                    switch (pch) {
                        case 1:
                            Patient p = new Patient();
                            sc.nextLine();
                            System.out.println("Name:");
                            p.setName(sc.nextLine());
                            System.out.println("DOB (yyyy-mm-dd):");
                            p.setDob(LocalDate.parse(sc.nextLine()));
                            System.out.println("Phone:");
                            p.setPhone(sc.nextLine());
                            System.out.println("Email:");
                            p.setEmail(sc.nextLine());
                            System.out.println("Address:");
                            p.setAddress(sc.nextLine());
                            System.out.println("Blood Group:");
                            p.setBloodGroup(sc.nextLine());

                            patient.addPatient(p);
                            break;

                        case 2:
                            System.out.println("Patient ID:");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("New Address:");
                            patient.updatePatient(id, sc.nextLine());
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.println("Name:");
                            List<Patient> list = patient.searchByName(sc.nextLine());
                            list.forEach(x
                                    -> System.out.println(x.getPatientId() + " | " + x.getName()));
                            break;

                        case 4:
                            System.out.println("Patient ID:");
                            patient.getVisitHistory(sc.nextInt());
                            break;
                    }
                    break;

                //DOCTOR
                case 2:
                    System.out.println("\n1.Add\n2.Update Specialty\n3.Deactivate");
                    int dch = sc.nextInt();

                    switch (dch) {
                        case 1:
                            Doctor d = new Doctor();
                            sc.nextLine();
                            System.out.println("Name:");
                            d.setName(sc.nextLine());
                            System.out.println("Specialty ID:");
                            d.setSpecialtyId(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Contact:");
                            d.setContact(sc.nextLine());
                            System.out.println("Fee:");
                            d.setConsultationFee(sc.nextDouble());
                            d.setActive(true);

                            doctor.addDoctor(d);
                            break;

                        case 2:
                            System.out.println("Doctor ID:");
                            int did = sc.nextInt();
                            System.out.println("New Specialty ID:");
                            doctor.updateDoctorSpecialty(did, sc.nextInt());
                            break;

                        case 3:
                            System.out.println("Doctor ID:");
                            doctor.deactivateDoctor(sc.nextInt());
                            break;
                    }
                    break;

                //APPOINTMENT 
                case 3:
                    System.out.println("\n1.Book\n2.Cancel\n3.Daily Schedule");
                    int ach = sc.nextInt();

                    switch (ach) {
                        case 1:
                            Appointment a = new Appointment();

                            System.out.println("Patient ID:");
                            a.setPatientId(sc.nextInt());

                            System.out.println("Doctor ID:");
                            a.setDoctorId(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Date (yyyy-mm-dd):");
                            a.setAppointmentDate(Date.valueOf(sc.nextLine()));

                            System.out.println("Time (HH:mm:ss):");
                            a.setAppointmentTime(Time.valueOf(sc.nextLine()));

                            appointment.bookAppointment(a);
                            break;

                        case 2:
                            System.out.println("Appointment ID:");
                            appointment.cancelAppointment(sc.nextInt());
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.println("Date (yyyy-mm-dd):");
                            appointment.getDailySchedule(Date.valueOf(sc.nextLine()));
                            break;
                    }
                    break;

                // VISIT 
                case 4:
                    System.out.println("\n1.Record Visit\n2.Add Prescription");
                    int vch = sc.nextInt();

                    switch (vch) {
                        case 1:
                            Visit v = new Visit();

                            System.out.println("Appointment ID:");
                            v.setAppointmentId(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Diagnosis:");
                            v.setDiagnosis(sc.nextLine());

                            System.out.println("Notes:");
                            v.setNotes(sc.nextLine());

                            visit.recordVisit(v);
                            break;

                        case 2:
                            System.out.println("Visit ID:");
                            int vid = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Enter medicines comma separated:");
                            List<String> meds = Arrays.asList(sc.nextLine().split(","));

                            visit.addPrescriptions(vid, meds);
                            break;
                    }
                    break;

                // BILLING 
                case 5:
                    System.out.println("\n1.Record Payment\n2.View Unpaid Bills");
                    int bch = sc.nextInt();

                    switch (bch) {
                        case 1:
                            PaymentTransaction p = new PaymentTransaction();

                            System.out.println("Bill ID:");
                            p.setBillId(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Payment Mode:");
                            p.setPaymentMode(sc.nextLine());

                            billing.recordPayment(p);
                            break;

                        case 2:
                            billing.getUnpaidBills();
                            break;
                    }
                    break;
                

                //SPECIALTY 
                case 6:
                    Specialty s = new Specialty();
                    sc.nextLine();
                    System.out.println("Name:");
                    s.setName(sc.nextLine());
                    System.out.println("Description:");
                    s.setDescription(sc.nextLine());

                    admin.addSpecialty(s);
                    break;

                case 0:
                    System.out.println("Goodbye !!");
                    System.exit(0);
            }
        }
    }
}
