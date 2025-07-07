import java.util.ArrayList;
import java.util.List;

public class InPatient extends Patient implements MedicalRecord {
    private List<String> records;
    private double dailyRate;
    private int daysAdmitted;

    public InPatient(int patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for InPatient " + getName() + ":");
        for (String record : records) {
            System.out.println(record);
        }
    }
}
