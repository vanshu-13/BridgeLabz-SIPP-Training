public class Clothing extends Product implements Taxable {
    private double taxRate;

    public Clothing(int productId, String name, double price, double taxRate) {
        super(productId, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        // Example discount logic for clothing
        return getPrice() * 0.1; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax rate: " + (taxRate * 100) + "%";
    }
}
