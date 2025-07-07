public class Car extends Vehicle implements Insurable {
    private double insuranceCost;

    public Car(String vehicleNumber, String type, double rentalRate, double insuranceCost) {
        super(vehicleNumber, type, rentalRate);
        this.insuranceCost = insuranceCost;
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return insuranceCost;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance cost: " + insuranceCost;
    }
}
