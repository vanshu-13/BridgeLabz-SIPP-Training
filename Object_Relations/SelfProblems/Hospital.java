npackage com.bridgelaz;

import java.util.*;

// Patient class
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Doctor class: can consult many patients
class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " consulted " + patient.getName());
    }
}

// Hospital class: holds lists of doctors and patients
class Hospital {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }
}

// Demo class
public class HospitalDemo {
    public static void main(String[] args) {
        Hospital h = new Hospital("Apollo");

        Doctor d1 = new Doctor("Sharma");
        Doctor d2 = new Doctor("Khan");

        Patient p1 = new Patient("Aarav");
        Patient p2 = new Patient("Isha");

        h.addDoctor(d1);
        h.addDoctor(d2);
        h.addPatient(p1);
        h.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p2);
    }
}
