public class VegItem extends FoodItem implements Discountable {
    private double discountPercentage;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discountPercentage = 0;
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        double discount = total * (discountPercentage / 100);
        return total - discount;
    }

    @Override
    public void applyDiscount(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discountPercentage + "%";
    }
}
