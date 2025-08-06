package com.bridgelabz;

import java.util.List;

abstract class JobRole {
    String roleName;
    JobRole(String roleName) { this.roleName = roleName; }
    public String toString() { return roleName; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    String candidateName;
    T role;

    Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public String toString() {
        return candidateName + " applying for " + role;
    }
}

class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resume for: " + role);
        }
    }
}
public class AI_ResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> resume2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> resume3 = new Resume<>("Charlie", new ProductManager());

        List<JobRole> roles = List.of(resume1.role, resume2.role, resume3.role);

        System.out.println("Resumes to be screened:");
        System.out.println(resume1);
        System.out.println(resume2);
        System.out.println(resume3);

        System.out.println("\nProcessing resumes...");
        ResumeProcessor.processResumes(roles);
        System.out.println("Resumes processed successfully!");
    }
}