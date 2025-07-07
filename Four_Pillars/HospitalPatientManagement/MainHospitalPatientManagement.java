import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHospitalPatientManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Patient> patients = new ArrayList<>();

        System.out.println("Enter number of patients:");
        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter patient type (1-InPatient, 2-OutPatient):");
            int type = s.nextInt();
            s.nextLine();

            System.out.println("Enter patient ID:");
            int patientId = s.nextInt();
            s.nextLine();

            System.out.println("Enter patient name:");
            String name = s.nextLine();

            System.out.println("Enter patient age:");
            int age = s.nextInt();
            s.nextLine();

            Patient patient = null;
            if (type == 1) {
                System.out.println("Enter daily rate:");
                double dailyRate = s.nextDouble();
                s.nextLine();

                System.out.println("Enter days admitted:");
                int daysAdmitted = s.nextInt();
                s.nextLine();

                patient = new InPatient(patientId, name, age, dailyRate, daysAdmitted);
            } else if (type == 2) {
                System.out.println("Enter consultation fee:");
                double consultationFee = s.nextDouble();
                s.nextLine();

                patient = new OutPatient(patientId, name, age, consultationFee);
            } else {
                System.out.println("Invalid patient type.");
                i--;
                continue;
            }
            patients.add(patient);
        }

        System.out.println("\nPatient Details and Bills:");
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.viewRecords();
            }
            System.out.println("-----------------------");
        }

        // Do not close Scanner s as per instructions
    }
}
