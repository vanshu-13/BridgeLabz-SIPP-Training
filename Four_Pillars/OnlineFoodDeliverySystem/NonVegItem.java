public class NonVegItem extends FoodItem implements Discountable {
    private double discountPercentage;
    private double additionalCharge;

    public NonVegItem(String itemName, double price, int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.discountPercentage = 0;
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() + additionalCharge) * getQuantity();
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
