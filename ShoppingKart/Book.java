package ShoppingKart;

class Book implements CartItem{
	private String title;
	private int quantity;
	private double prices;
	
	public Book(String title , int quantity, double price) {
		this.title = title ;
		this.quantity=quantity;
		this.price = price;
	}
	
	
	@Override
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public double getPrice() {
		return price;
	}
	

	
	@Override
	public String toString() {
		return "Book: " + title + (Qty: " + quantity + ", Price: " + price +")";
	}

}
