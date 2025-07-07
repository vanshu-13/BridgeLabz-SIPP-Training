public class Electronics extends Product implements Taxable {
    private double taxRate;

    public Electronics(int productId, String name, double price, double taxRate) {
        super(productId, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        // Example discount logic for electronics
        return getPrice() * 0.05; // 5% discount
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
